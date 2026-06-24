package net.arsik.ratt.fabric.datagen;

import net.arsik.ratt.common.register.StandTypeRegistry;
import net.arna.jcraft.api.datagen.JCraftStandDataProvider;
import net.arna.jcraft.api.stand.StandData;
import net.arsik.ratt.common.stand.RattEntity;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.resources.ResourceLocation;

import java.util.function.BiConsumer;

public class RattDataProvider extends JCraftStandDataProvider {
    public RattDataProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    protected void configure(BiConsumer<ResourceLocation, StandData> provider) {
        provider.accept(StandTypeRegistry.RATT.getId(), RattEntity.DATA);
    }
}
