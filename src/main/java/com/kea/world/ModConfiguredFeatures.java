package com.kea.world;

import com.kea.DirtMagic;
import com.kea.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?,?>>
            DIRT_ORE_KEY = registryKey("dirt_ore");
    public static final RegistryKey<ConfiguredFeature<?,?>>
            DEEPSLATE_DIRT_ORE_KEY = registryKey("deepslate_dirt_ore");

    public static void boostrap(Registerable<ConfiguredFeature<?,?>> context){
        RuleTest OrePlace = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest DeepslateOrePlace = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> OverWorld =
                List.of(OreFeatureConfig.createTarget(OrePlace, ModBlocks.DIRT_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(DeepslateOrePlace, ModBlocks.DEEPSLATE_DIRT_ORE.getDefaultState()));

        register(context,DIRT_ORE_KEY,Feature.ORE,new OreFeatureConfig(OverWorld,8));
        register(context,DEEPSLATE_DIRT_ORE_KEY,Feature.ORE,new OreFeatureConfig(OverWorld,6));
    }

    public static RegistryKey<ConfiguredFeature<?,?>> registryKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE,new Identifier(DirtMagic.MOD_ID,name));
    }
    public static <FC extends FeatureConfig,F extends Feature<FC>> void
        register(Registerable<ConfiguredFeature<?,?>> context,RegistryKey<ConfiguredFeature<?,?>>
                 key,F feature,FC configuration){
        context.register(key,new ConfiguredFeature<>(feature,configuration));
    }
}
