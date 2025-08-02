package com.kea;

import com.kea.entity.ModEntities;
import com.kea.entity.ProjectileRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class DirtMagicModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.DIRT_PROJECTILE, ProjectileRenderer::new);
    }
}
