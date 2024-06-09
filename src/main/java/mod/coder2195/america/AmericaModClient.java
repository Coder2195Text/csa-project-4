package mod.coder2195.america;

import mod.coder2195.america.entity.ModEntities;
import mod.coder2195.america.entity.client.*;
import mod.coder2195.america.event.KeyEventHandler;
import mod.coder2195.america.networking.ModMessages;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;


@Environment(EnvType.CLIENT)
public class AmericaModClient implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    AmericaMod.LOGGER.info("Hello Fabric world! (Client)");



    KeyEventHandler.register();

    ModMessages.registerS2CPackets();

    EntityRendererRegistry.register(ModEntities.BULLET, BulletEntityRenderer::new);
    EntityRendererRegistry.register(ModEntities.SMOKE_GRENADE, FlyingItemEntityRenderer::new);
    EntityRendererRegistry.register(ModEntities.TANK_SHELL, TankShellEntityRenderer::new);
    EntityRendererRegistry.register(ModEntities.GRENADE, FlyingItemEntityRenderer::new);
    EntityRendererRegistry.register(ModEntities.INCENDIARY_GRENADE, FlyingItemEntityRenderer::new);
    EntityRendererRegistry.register(ModEntities.FLASHBANG, FlyingItemEntityRenderer::new);
    EntityRendererRegistry.register(ModEntities.M1A2, M1A2Renderer::new);


    EntityModelLayerRegistry.registerModelLayer(ModModelLayers.M1A2, M1A2Model::getTexturedModelData);
  }
}
