package com.kea.item.wands;

import com.kea.entity.DirtProjectile;
import com.kea.entity.ModEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DirtWand extends Item {
    public DirtWand(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);

        if (player.isSneaking()){
            placeDirt(world,player);
            player.getItemCooldownManager().set(this,10);
        }
        else {
            if (!world.isClient) {
                DirtProjectile projectile = new DirtProjectile(ModEntities.DIRT_PROJECTILE, world);
                projectile.setPosition(player.getX(), player.getEyeY(), player.getZ());
                projectile.setVelocity(player, player.getPitch(), player.getYaw(), 0.0f, 1.5f, 1.0f);
                world.spawnEntity(projectile);
                player.getItemCooldownManager().set(this,20);
            }
        }
        return TypedActionResult.success(itemStack);
    }

    private void placeDirt(World world,PlayerEntity player){
        HitResult hitResult = player.raycast(5.0,0.0f,false);

        if (hitResult.getType() == HitResult.Type.BLOCK){
            BlockHitResult blockHitResult = (BlockHitResult) hitResult;
            BlockPos pos = blockHitResult.getBlockPos().offset(blockHitResult.getSide());

            BlockState blockState = world.getBlockState(pos);
            if (blockState.isAir() || blockState.isReplaceable()){
                if (!world.isClient){
                    world.setBlockState(pos, Blocks.DIRT.getDefaultState());
                }
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.literal("§2右键："));
        tooltip.add(Text.literal("§7发射泥土法球，造成5点魔法伤害（冷却时间1秒）"));
        tooltip.add(Text.literal("§2潜行时右键："));
        tooltip.add(Text.literal("§7在准心位置放置泥土（冷却时间0.5秒）"));
    }
}
