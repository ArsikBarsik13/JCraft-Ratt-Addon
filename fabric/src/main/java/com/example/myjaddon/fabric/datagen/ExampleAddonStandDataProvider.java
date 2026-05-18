package com.example.myjaddon.fabric.datagen;

import com.example.myjaddon.common.register.StandTypeRegistry;
import com.example.myjaddon.common.stand.ExampleStandEntity;
import net.arna.jcraft.api.datagen.JCraftStandDataProvider;
import net.arna.jcraft.api.stand.StandData;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.resources.ResourceLocation;

import java.util.function.BiConsumer;

public class ExampleAddonStandDataProvider extends JCraftStandDataProvider {
    public ExampleAddonStandDataProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    protected void configure(BiConsumer<ResourceLocation, StandData> provider) {
        provider.accept(StandTypeRegistry.EXAMPLE_STAND.getId(), ExampleStandEntity.DATA);
    }
}
