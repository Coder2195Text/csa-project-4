package mod.coder2195.america.blocks.custom;

import mod.coder2195.america.AmericaMod;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
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
        BlockState state);
  }

  private static final BlockRoll[] rolls = {
      (world, server, pos, state) -> {

      }
  };

  @Override
  public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
    // TODO Auto-generated method stub
    if (world.isClient())
      return super.onBreak(world, pos, state, player);

    MinecraftServer server = world.getServer();
  
    int roll = (int) (Math.random() * rolls.length);
    rolls[roll].roll(world, server, pos, state);

    return super.onBreak(world, pos, state, player);
  }

  public AmericanDreamBlock() {
    super(FabricBlockSettings.copyOf(Blocks.RED_WOOL).dropsNothing());
  }
}
