package com.kea.advancement;

import com.kea.DirtMagic;
import com.kea.item.ModItems;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.TickCriterion;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

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
    }
}
