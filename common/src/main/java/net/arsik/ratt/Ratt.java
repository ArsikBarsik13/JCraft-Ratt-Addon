package net.arsik.ratt;

import net.arsik.ratt.common.register.EntityTypeRegistry;
import net.arsik.ratt.common.register.StandTypeRegistry;
import net.minecraft.resources.ResourceLocation;

public final class Ratt {
    public static final String MOD_ID = "ratt";
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
