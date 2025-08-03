package com.kea.blockentity;

import com.kea.item.ModItems;
import com.kea.screen.MagicTransformTableScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MagicTransformTableBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory,ImplementedInventory{
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);
    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;

    protected final PropertyDelegate propertyDelegate;

    private int progress = 0;
    private int maxProgress = 36;

    public MagicTransformTableBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MAGIC_TRANSFORM_TABLE_BLOCK_ENTITY,pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index){
                    case 0 -> MagicTransformTableBlockEntity.this.progress;
                    case 1 -> MagicTransformTableBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index){
                    case 0 -> MagicTransformTableBlockEntity.this.progress = value;
                    case 1 -> MagicTransformTableBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity serverPlayerEntity, PacketByteBuf packetByteBuf) {
        packetByteBuf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new MagicTransformTableScreenHandler(syncId,playerInventory,this,this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt,inventory);
        nbt.putInt("magic_transform_table",progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt,inventory);
        progress = nbt.getInt("magic_transform_table");
    }

    public void tick(World world1,BlockPos pos,BlockState state1){
        if (world1.isClient){
            return;
        }
        if (isOutputSlotAvailable()){
            if (this.hasRecipe()){
                this.increaseCraftProgress();
                markDirty(world1,pos,state1);
                if (hasCraftingFinished()){
                    this.craftItem();
                    this.resetProgress();
                }
            }
            else {
                this.resetProgress();
            }
        }
        else {
            this.resetProgress();
            markDirty(world1,pos,state1);
        }
    }

    private void resetProgress(){
        this.progress = 0;
    }

    private void craftItem(){
        this.removeStack(INPUT_SLOT,1);
        ItemStack result = new ItemStack(ModItems.MAGIC_DUST);
        this.setStack(OUTPUT_SLOT,new ItemStack(result.getItem(),getStack(OUTPUT_SLOT).getCount() + result.getCount()));
    }

    private boolean hasCraftingFinished(){
        return progress >= maxProgress;
    }

    private void increaseCraftProgress(){
        progress++;
    }

    private boolean hasRecipe(){
        ItemStack result = new ItemStack(ModItems.MAGIC_DUST);
        boolean hasInput = getStack(INPUT_SLOT).getItem() == Items.IRON_INGOT;

        return hasInput && canInsertAmountIntoOutputSlot(result) && canInsertItemIntoOutputSlot(result.getItem());
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result){
        return this.getStack(OUTPUT_SLOT).getCount() + result.getCount() <= getStack(OUTPUT_SLOT).getMaxCount();
    }

    private boolean canInsertItemIntoOutputSlot(Item item){
        return this.getStack(OUTPUT_SLOT).getItem() == item || this.getStack(OUTPUT_SLOT).isEmpty();
    }

    private boolean isOutputSlotAvailable(){
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getCount()
                < this.getStack(OUTPUT_SLOT).getMaxCount();
    }
}
