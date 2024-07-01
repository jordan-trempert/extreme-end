package stardom.extremeend.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class EnderFlameBlock
        extends AbstractFireBlock {
    public static final MapCodec<net.minecraft.block.SoulFireBlock> CODEC = net.minecraft.block.SoulFireBlock.createCodec(net.minecraft.block.SoulFireBlock::new);

    public MapCodec<net.minecraft.block.SoulFireBlock> getCodec() {
        return CODEC;
    }

    public EnderFlameBlock(AbstractBlock.Settings settings) {
        super(settings, 2.0f);
    }

    @Override
    protected BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (this.canPlaceAt(state, world, pos)) {
            return this.getDefaultState();
        }
        return Blocks.AIR.getDefaultState();
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return isEnderBase(world.getBlockState(pos.down()));
    }

    public static boolean isEnderBase(BlockState state) {
        return state.isIn(ModBlockTags.ENDER_BASE_BLOCKS);
    }

    @Override
    protected boolean isFlammable(BlockState state) {
        return true;
    }
}
