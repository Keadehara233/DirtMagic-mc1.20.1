package com.kea.advancement;

import com.kea.DirtMagic;
import com.kea.item.ModItems;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.TickCriterion;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import vazkii.patchouli.common.item.PatchouliItems;

import java.util.function.Consumer;

public class ModAdvancements implements Consumer<Consumer<Advancement>> {
    @Override
    public void accept(Consumer<Advancement> advancementConsumer) {
        Advancement WELCOME = Advancement.Builder.create().display(
                        ModItems.DIRT_INGOT, Text.literal("泥土魔法"),Text.literal("探索这片大地的秘密吧！"),
                new Identifier("dirtmagic:textures/gui/advancements/backgrounds/dirt_magic.png"),
                AdvancementFrame.TASK,true,true,false)
                .rewards(AdvancementRewards.Builder.loot(new Identifier("dirtmagic:new_book")))
                .criterion("welcome", TickCriterion.Conditions.createTick())
                .build(advancementConsumer, DirtMagic.MOD_ID + "/welcome");

        Advancement GOT_DIRT_INGOT = Advancement.Builder.create().parent(WELCOME).display(
                        ModItems.DIRT_PICKAXE, Text.literal("泥土时代"),Text.literal("获得泥土锭"),
                        null, AdvancementFrame.TASK,true,true,false)
                .criterion("got_dirt_ingot", InventoryChangedCriterion.Conditions.items(ModItems.DIRT_INGOT))
                .build(advancementConsumer, DirtMagic.MOD_ID + "/got_dirt_ingot");

        Advancement GOT_DIRT_WAND = Advancement.Builder.create().parent(GOT_DIRT_INGOT).display(
                        ModItems.WAND_OF_DIRT, Text.literal("新手魔法师"),Text.literal("获得泥土法杖"),
                        null, AdvancementFrame.TASK,true,true,false)
                .criterion("got_dirt_wand", InventoryChangedCriterion.Conditions.items(ModItems.WAND_OF_DIRT))
                .build(advancementConsumer, DirtMagic.MOD_ID + "/got_dirt_wand");
    }
}
