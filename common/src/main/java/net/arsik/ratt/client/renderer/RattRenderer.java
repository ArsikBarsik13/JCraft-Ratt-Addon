package net.arsik.ratt.client.renderer;

import net.arsik.ratt.common.register.StandTypeRegistry;
import net.arna.jcraft.client.renderer.entity.stands.StandEntityRenderer;
import net.arsik.ratt.common.stand.RattEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class RattRenderer extends StandEntityRenderer<RattEntity> {
    public RattRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, StandTypeRegistry.RATT.get());
    }
}
