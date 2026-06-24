package net.arsik.ratt.client.register;

import net.arsik.ratt.client.renderer.RattRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

import java.util.function.Supplier;

public interface EntityRendererRegister {
    static void register(EntityRendererRegistrar registrar) {
        registrar.register(net.arsik.ratt.common.register.EntityTypeRegistry.RATT, RattRenderer::new);
    }

    @FunctionalInterface
    interface EntityRendererRegistrar {
        <T extends Entity> void register(Supplier<? extends EntityType<? extends T>> type,
                                         EntityRendererProvider<T> rendererProvider);
    }
}
