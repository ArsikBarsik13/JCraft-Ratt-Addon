package net.arsik.ratt.common.register;

import net.arsik.ratt.Ratt;
import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.arsik.ratt.common.stand.RattEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public interface EntityTypeRegistry {
    DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Ratt.MOD_ID, Registries.ENTITY_TYPE);

    RegistrySupplier<EntityType<RattEntity>> RATT = REGISTRY.register("ratt", () ->
            EntityType.Builder.of((EntityType.EntityFactory<RattEntity>)
                            (t, level) -> new RattEntity(level),
                            MobCategory.CREATURE)
                    .sized(0.6f, 1.0f)
                    .build("ratt"));

    static void registerAttributes() {
        EntityAttributeRegistry.register(RATT, RattEntity::createMobAttributes);
    }
}
