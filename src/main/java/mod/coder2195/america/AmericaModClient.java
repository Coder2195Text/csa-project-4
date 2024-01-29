package mod.coder2195.america;

import mod.coder2195.america.entity.ModEntities;
import mod.coder2195.america.entity.client.BulletEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class AmericaModClient implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    AmericaMod.LOGGER.info("Hello Fabric world! (Client)");

    EntityRendererRegistry.register(ModEntities.BULLET, BulletEntityRenderer::new);
  }
}
