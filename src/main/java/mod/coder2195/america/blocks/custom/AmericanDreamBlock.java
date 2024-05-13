package mod.coder2195.america.blocks.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AmericanDreamBlock extends Block {
  @FunctionalInterface
  private static interface BlockRoll {
    void roll(
        World world,
        MinecraftServer server,
        BlockPos pos,
        BlockState state,
        PlayerEntity player);
  }

  private static final BlockRoll[] rolls = {
      (world, server, pos, state, player) -> {
        if (world.isClient())
          return;

        player.sendMessage(Text.of("You have stepped into Florida."));
        for (int x = -7; x <= 7; x++) {
          for (int z = -7; z <= 7; z++) {
            BlockPos newPos = pos.add(x, 0, z);
            EntityType.LIGHTNING_BOLT
                .spawn((ServerWorld) player.getWorld(), newPos, SpawnReason.EVENT);
          }
        }
      },
      (world, server, pos, state, player) -> {
        if (world.isClient())
          return;

        player.sendMessage(Text.of("You have stepped into Kansas."));
        for (int x = -7; x <= 7; x++) {
          for (int z = -7; z <= 7; z++) {
            for (int y = 255; y > 32; y--) {
              Block target = world.getBlockState(pos.add(x, 0, z).withY(y)).getBlock();
              if (!(target == Blocks.GRASS_BLOCK || target == Blocks.DIRT || target == Blocks.FARMLAND))
                continue;

              BlockState targetUp = world.getBlockState(pos.add(x, 0, z).withY(y + 1));
              if (!targetUp.isReplaceable())
                break;


              CropBlock crop = (CropBlock) Blocks.WHEAT;
              

              // set to farmland
              world.setBlockState(pos.add(x, 0, z).withY(y), Blocks.FARMLAND.getDefaultState());
              world.setBlockState(pos.add(x, 0, z).withY(y + 1), crop.withAge(7));
            }
          }
        }

      },
      (world, server, pos, state, player) -> {
        if (world.isClient())
          return;

        player.sendMessage(Text.of("The government has increased taxes."));
        PlayerInventory inventory = player.getInventory();
        for (int i=0; i< inventory.size(); i++) {
          inventory.removeStack(i);
        }
        player.setHealth(1);
      }
  };

  @Override
  public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
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
