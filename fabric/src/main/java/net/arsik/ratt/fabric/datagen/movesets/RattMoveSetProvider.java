package net.arsik.ratt.fabric.datagen.movesets;

import net.arsik.ratt.common.register.StandTypeRegistry;
import net.arna.jcraft.api.attack.MoveMap;
import net.arna.jcraft.api.attack.MoveSet;
import net.arna.jcraft.api.datagen.JCraftMoveSetProvider;
import net.arsik.ratt.common.stand.RattEntity;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;

import java.util.function.Consumer;

public class RattMoveSetProvider extends JCraftMoveSetProvider<RattEntity, RattEntity.State> {
    public RattMoveSetProvider(FabricDataOutput dataOutput) {
        super(dataOutput, MoveMap.Entry.codecFor(RattEntity.State.class), StandTypeRegistry.RATT.getId());
    }

    @Override
    protected void configureMoveSets(Consumer<MoveSet<RattEntity, RattEntity.State>> provider) {
        provider.accept(RattEntity.MOVE_SET);
    }
}
