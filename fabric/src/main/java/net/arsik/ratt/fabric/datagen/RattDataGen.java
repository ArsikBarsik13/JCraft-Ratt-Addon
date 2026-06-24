package net.arsik.ratt.fabric.datagen;

import net.arsik.ratt.fabric.datagen.movesets.RattMoveSetProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class RattDataGen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGen) {
        FabricDataGenerator.Pack pack = dataGen.createPack();
        pack.addProvider(RattMoveSetProvider::new);
        pack.addProvider(RattDataProvider::new);
    }
}
