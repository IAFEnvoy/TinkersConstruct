package slimeknights.tconstruct.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.FungusBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.HugeFungusConfiguration;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.world.worldgen.trees.feature.SlimeFungusFeature;

/** Update of fungus that grows on slime soil instead */
public class SlimeFungusBlock extends FungusBlock {
  public SlimeFungusBlock(Properties properties, ResourceKey<ConfiguredFeature<?, ?>> fungusFeature) {
    super(properties, fungusFeature, null);
  }

  @Override
  public boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
    return state.is(TinkerTags.Blocks.SLIMY_SOIL);
  }

  @Override
  public boolean isValidBonemealTarget(LevelReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
    return worldIn.getBlockState(pos.below()).is(TinkerTags.Blocks.SLIMY_SOIL);
  }
}
