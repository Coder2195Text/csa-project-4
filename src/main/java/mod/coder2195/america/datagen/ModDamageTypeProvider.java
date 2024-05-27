package mod.coder2195.america.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;

import mod.coder2195.america.AmericaMod;
import mod.coder2195.america.effects.ModDamageTypes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.DataOutput.OutputType;
import net.minecraft.data.DataOutput.PathResolver;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.util.Identifier;

public class ModDamageTypeProvider implements DataProvider {
  public static final String FILE_PATH = "damage_type";

  private final PathResolver path;

  public ModDamageTypeProvider(FabricDataOutput generator) {
    this.path = generator.getResolver(OutputType.DATA_PACK, FILE_PATH + "/");
  }

  public CompletableFuture<?> run(DataWriter dataWriter) {
    List<CompletableFuture<?>> futures = Lists.newArrayList();

    ModDamageTypes.sources().forEach(type -> {
      JsonObject obj = new JsonObject();
      obj.addProperty("message_id", type.msgId());
      obj.addProperty("exhaustion", type.exhaustion());
      obj.addProperty("scaling", type.scaling().asString());
      obj.addProperty("effects", type.effects().asString());
      obj.addProperty("death_message_type", type.deathMessageType().asString());
      futures.add(DataProvider.writeToPath(dataWriter, obj,
          this.path.resolveJson(new Identifier(AmericaMod.MOD_ID, type.msgId()))));
    });
    return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
  }

  public String getName() {
    return "Damage Types";
  }
}
