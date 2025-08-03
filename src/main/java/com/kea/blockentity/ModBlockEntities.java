package com.kea.blockentity;

import com.kea.DirtMagic;
import com.kea.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<MagicTransformTableBlockEntity> MAGIC_TRANSFORM_TABLE_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE,new Identifier(DirtMagic.MOD_ID,
                            "magic_transform_table_block_entity"),
                    FabricBlockEntityTypeBuilder.create(MagicTransformTableBlockEntity::new,
                            ModBlocks.MAGIC_TRANSFORM_TABLE).build());
    public static void registerBlockEntities(){

    }
}
