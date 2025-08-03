package com.kea.screen;

import com.kea.DirtMagic;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<MagicTransformTableScreenHandler> MAGIC_TRANSFORM_TABLE_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER,new Identifier(DirtMagic.MOD_ID,"magic_transform_table"),
                    new ExtendedScreenHandlerType<>(MagicTransformTableScreenHandler::new));

    public static void registerScreenHandlers(){

    }
}
