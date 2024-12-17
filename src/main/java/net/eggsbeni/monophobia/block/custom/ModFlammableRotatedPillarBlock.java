package net.eggsbeni.monophobia.block.custom;

import net.eggsbeni.monophobia.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.Nullable;

//what is this?
//good question, it's because we want our custom wood to be flammable, and doing all that in modblocks is overly complicated

public class ModFlammableRotatedPillarBlock extends RotatedPillarBlock {
    public ModFlammableRotatedPillarBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    // we change the gettoolmodifiedstate, so that we can strip the log by checking if the player is using an instance of axe
    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
        if(context.getItemInHand().getItem() instanceof AxeItem) {
            if(state.is(ModBlocks.SECLUDED_LOG.get())) {
                //the axis stuff here means that when the block is stripped it keeps its orientation
                return ModBlocks.STRIPPED_SECLUDED_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

            if(state.is(ModBlocks.SECLUDED_WOOD.get())) {
                return ModBlocks.STRIPPED_SECLUDED_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

        }
        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }
}
