package com.kea;

import com.kea.entity.ModEntities;
import com.kea.entity.dirtprojectile.DirtProjectileRenderer;
import com.kea.screen.MagicTransformTableScreen;
import com.kea.screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class DirtMagicModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.DIRT_PROJECTILE, DirtProjectileRenderer::new);

        HandledScreens.register(ModScreenHandlers.MAGIC_TRANSFORM_TABLE_SCREEN_HANDLER,
                MagicTransformTableScreen::new);
    }
}
