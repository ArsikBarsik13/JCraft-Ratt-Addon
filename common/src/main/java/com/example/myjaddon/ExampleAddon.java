package com.example.myjaddon;

import com.example.myjaddon.common.register.EntityTypeRegistry;
import com.example.myjaddon.common.register.StandTypeRegistry;
import net.minecraft.resources.ResourceLocation;

public final class ExampleAddon {
    public static final String MOD_ID = "myjaddon";
    public static final String BASE_CONTROLLER = "base_controller";

    public static void init() {
        EntityTypeRegistry.REGISTRY.register();
        StandTypeRegistry.REGISTRY.register();

        EntityTypeRegistry.registerAttributes();
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
