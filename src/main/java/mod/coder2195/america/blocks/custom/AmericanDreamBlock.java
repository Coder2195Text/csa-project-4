package mod.coder2195.america.blocks.custom;

import mod.coder2195.america.AmericaMod;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class AmericanDreamBlock extends Block {
  @FunctionalInterface
  private static interface BlockRoll {
    void roll(
        WorldAccess world,
        MinecraftServer server,
        BlockPos pos,
        BlockState state,
        PlayerEntity player);
  }

  private static final BlockRoll[] rolls = {
      (world, server, pos, state, player) -> {
        if (world.isClient())
          return;
        server.sendMessage(Text.of("You have stepped into Florida."));
        for (int i = 0; i < 300; i++) {

          LightningEntity lightning = EntityType.LIGHTNING_BOLT
              .spawn((ServerWorld) player.getWorld(), pos, SpawnReason.EVENT);

        }
      }
  };

  @Override
  public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
    // TODO Auto-generated method stub
    if (world.isClient())
      return super.onBreak(world, pos, state, player);

    MinecraftServer server = world.getServer();

    int roll = (int) (Math.random() * rolls.length);
    rolls[roll].roll(world, server, pos, state, player);

    return super.onBreak(world, pos, state, player);
  }

  public AmericanDreamBlock() {
    super(FabricBlockSettings.copyOf(Blocks.RED_WOOL).dropsNothing());
  }
}
