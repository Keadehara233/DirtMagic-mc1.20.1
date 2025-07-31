package com.kea.world;

import com.kea.DirtMagic;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature>
            DIRT_ORE_PLACED_KEY = registryKey("dirt_ore_placed");
    public static final RegistryKey<PlacedFeature>
            DEEPSLATE_DIRT_ORE_PLACED_KEY = registryKey("deepslate_dirt_ore_placed");

    public static void boostrap(Registerable<PlacedFeature> context){
        var ConfiguredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        register(context,DIRT_ORE_PLACED_KEY,
                ConfiguredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DIRT_ORE_KEY),
                ModOrePlacement.modifiersWithCount(8,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(10),YOffset.fixed(80))));
        register(context,DEEPSLATE_DIRT_ORE_PLACED_KEY,
                ConfiguredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DEEPSLATE_DIRT_ORE_KEY),
                ModOrePlacement.modifiersWithCount(4,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(0),YOffset.fixed(-30))));
    }

    public static RegistryKey<PlacedFeature> registryKey(String name){
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE,new Identifier(DirtMagic.MOD_ID,name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?,?>> configuration,
                                 List<PlacementModifier> modifiers){
        context.register(key,new PlacedFeature(configuration,List.copyOf(modifiers)));
    }
}
