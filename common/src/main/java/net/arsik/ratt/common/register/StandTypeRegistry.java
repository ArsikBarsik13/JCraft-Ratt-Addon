package net.arsik.ratt.common.register;

import net.arsik.ratt.Ratt;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.arna.jcraft.api.JRegistries;
import net.arna.jcraft.api.stand.StandType;

public interface StandTypeRegistry {
    DeferredRegister<StandType> REGISTRY = DeferredRegister.create(Ratt.MOD_ID, JRegistries.STAND_TYPE_REGISTRY_KEY);

    RegistrySupplier<StandType> RATT = REGISTRY.register(Ratt.id("ratt"), () ->
            StandType.of(Ratt.id("ratt"), EntityTypeRegistry.RATT));
}
