package net.arsik.ratt.fabric;

import net.fabricmc.api.ModInitializer;

import net.arsik.ratt.Ratt;

public final class RattFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        Ratt.init();
    }
}
