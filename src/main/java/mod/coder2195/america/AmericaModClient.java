package mod.coder2195.america;

import net.fabricmc.api.ClientModInitializer;

public class AmericaModClient implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    AmericaMod.LOGGER.info("Hello Fabric world! (Client)");
  }
}
