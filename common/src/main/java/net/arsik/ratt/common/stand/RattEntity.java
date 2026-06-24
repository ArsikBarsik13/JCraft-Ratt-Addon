package net.arsik.ratt.common.stand;

import net.arsik.ratt.Ratt;
import net.arsik.ratt.common.register.StandTypeRegistry;
import mod.azure.azurelib.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.animation.play_behavior.AzPlayBehaviors;
import net.arna.jcraft.api.attack.MoveMap;
import net.arna.jcraft.api.attack.MoveSet;
import net.arna.jcraft.api.attack.MoveSetManager;
import net.arna.jcraft.api.attack.enums.MoveClass;
import net.arna.jcraft.api.registry.JSoundRegistry;
import net.arna.jcraft.api.stand.StandData;
import net.arna.jcraft.api.stand.StandEntity;
import net.arna.jcraft.api.stand.StandInfo;
import net.arna.jcraft.common.attack.moves.shared.MainBarrageAttack;
import net.arna.jcraft.common.attack.moves.shared.SimpleAttack;
import net.arna.jcraft.common.util.StandAnimationState;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

public class RattEntity extends StandEntity<RattEntity, RattEntity.State> {
    public static final MoveSet<RattEntity, State> MOVE_SET = MoveSetManager.create(StandTypeRegistry.RATT,
            RattEntity::registerMoves, State.class);
    public static final StandData DATA = StandData.of(StandInfo.of(Component.literal("Ratt")));

    public static final SimpleAttack<RattEntity> CROUCHING_FIRE = new SimpleAttack<RattEntity>(
            80, 2, 8, 0.75f, 5f, 16, 1.5f, 0.2f, -0.1f)
            .withImpactSound(JSoundRegistry.IMPACT_1)
            .withInfo(
                    Component.literal("Concetrated Fire"),
                    Component.literal("Fires multiple shots, can be canceled into itself, doesn't cancel the opponents moves or inflict stun")
            );
    public static final SimpleAttack<RattEntity> FIRE = new SimpleAttack<RattEntity>(
            80, 2, 8, 0.75f, 5f, 0, 1.5f, 0.2f, -0.1f)
            .withImpactSound(JSoundRegistry.IMPACT_1)
            .withCrouchingVariant(CROUCHING_FIRE)
            .withInfo(
                    Component.literal("Fire!"),
                    Component.literal("Fires multiple shots, can be canceled into itself, doesn't cancel the opponents moves or inflict stun")
            );

    public RattEntity(Level world) {
        super(StandTypeRegistry.RATT.get(), world);
    }

    private static void registerMoves(MoveMap<RattEntity, State> moveMap) {
        moveMap.register(MoveClass.LIGHT, FIRE, State.LIGHT);
        moveMap.register(MoveClass.LIGHT, CROUCHING_FIRE, State.LIGHT);
    }

    @NotNull
    @Override
    public RattEntity getThis() {
        return this;
    }

    @Override
    protected State[] getStateValues() {
        return State.values();
    }

    @Override
    public State getBlockState() {
        return State.BLOCK;
    }

    public enum State implements StandAnimationState<RattEntity> {
        IDLE(AzCommand.create(Ratt.BASE_CONTROLLER, "idle", AzPlayBehaviors.LOOP)),
        LIGHT(AzCommand.create(Ratt.BASE_CONTROLLER, "light", AzPlayBehaviors.HOLD_ON_LAST_FRAME)),
        BLOCK(AzCommand.create(Ratt.BASE_CONTROLLER, "block", AzPlayBehaviors.LOOP)),
        BARRAGE(AzCommand.create(Ratt.BASE_CONTROLLER, "barrage", AzPlayBehaviors.LOOP));

        private final AzCommand animator;

        State(AzCommand animator) {
            this.animator = animator;
        }

        @Override
        public void playAnimation(RattEntity attacker) {
            animator.sendForEntity(attacker);
        }
    }
}
