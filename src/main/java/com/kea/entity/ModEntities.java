package com.kea.entity;

import com.kea.DirtMagic;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<DirtProjectile> DIRT_PROJECTILE =
            register("dirt_projectile",
                    FabricEntityTypeBuilder.<DirtProjectile>create(SpawnGroup.MISC,DirtProjectile::new)
                            .dimensions(EntityDimensions.fixed(0.5f,0.5f))
                            .trackRangeBlocks(4).trackedUpdateRate(10).build());

    public static <T extends EntityType<?>> T register(String id,T EntityType){
        return Registry.register(Registries.ENTITY_TYPE,new Identifier(DirtMagic.MOD_ID, id),EntityType);
    }

    public static void registerModEntities(){

    }
}
