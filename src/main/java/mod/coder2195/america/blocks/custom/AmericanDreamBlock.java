package mod.coder2195.america.blocks.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;

public class AmericanDreamBlock extends Block {
  
  public AmericanDreamBlock() {
    super(FabricBlockSettings.copyOf(Blocks.RED_WOOL).dropsNothing());
  }

  @Override
  public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
    // TODO Auto-generated method stub
    super.onBroken(world, pos, state);

  }
}
