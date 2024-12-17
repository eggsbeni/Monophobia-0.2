package net.eggsbeni.monophobia.block;

import net.eggsbeni.monophobia.MonophobiaMod;
import net.eggsbeni.monophobia.block.custom.ModFlammableRotatedPillarBlock;
import net.eggsbeni.monophobia.item.ModItems;
import net.eggsbeni.monophobia.worldgen.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(MonophobiaMod.MOD_ID);

    //Opaque Building Blocks

    public static final DeferredBlock<Block> OPAQUE_BLOCK = registerBlock("opaque_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    //Opaque Ore Blocks

    public static final DeferredBlock<Block> OPAQUE_ORE = registerBlock("opaque_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 5),
                BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> DEEPSLATE_OPAQUE_ORE = registerBlock("deepslate_opaque_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 5),
                BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

  public static final DeferredBlock<Block> RAW_OPAQUE_BLOCK = registerBlock("raw_opaque_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    //Invasive Rock Building Blocks

    public static final DeferredBlock<Block> INVASIVE_ROCK = registerBlock("invasive_rock",
            () -> new Block(BlockBehaviour.Properties.of().strength(2.0f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> INVASIVE_ROCK_STAIRS = registerBlock("invasive_rock_stairs",
            () -> new StairBlock(ModBlocks.INVASIVE_ROCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2.0f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> INVASIVE_ROCK_SLAB = registerBlock("invasive_rock_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2.0f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> INVASIVE_ROCK_WALL = registerBlock("invasive_rock_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    //Invasive Stone Building Blocks

    public static final DeferredBlock<Block> INVASIVE_STONE = registerBlock("invasive_stone",
            () -> new Block(BlockBehaviour.Properties.of().strength(2.0f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> INVASIVE_STONE_STAIRS = registerBlock("invasive_stone_stairs",
            () -> new StairBlock(ModBlocks.INVASIVE_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2.0f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> INVASIVE_STONE_SLAB = registerBlock("invasive_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2.0f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> INVASIVE_STONE_PRESSURE_PLATE = registerBlock("invasive_stone_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> INVASIVE_STONE_BUTTON = registerBlock("invasive_stone_button",
            () -> new ButtonBlock(BlockSetType.IRON, 10, BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noCollission()));

    //Invasive Bricks Building Blocks

    public static final DeferredBlock<Block> INVASIVE_BRICK = registerBlock("invasive_brick",
            () -> new Block(BlockBehaviour.Properties.of().strength(2.0f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> INVASIVE_BRICK_STAIRS = registerBlock("invasive_brick_stairs",
            () -> new StairBlock(ModBlocks.INVASIVE_BRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2.0f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> INVASIVE_BRICK_SLAB = registerBlock("invasive_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2.0f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> INVASIVE_BRICK_WALL = registerBlock("invasive_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    //Invasive Smooth Stone Building Blocks

    public static final DeferredBlock<Block> SOLIDIFIED_INVASIVE_STONE = registerBlock("solidified_invasive_stone",
            () -> new Block(BlockBehaviour.Properties.of().strength(2.0f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> SOLIDIFIED_INVASIVE_STONE_SLAB = registerBlock("solidified_invasive_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2.0f).requiresCorrectToolForDrops()));


    //Secluded Wood Set

    public static final DeferredBlock<Block> SECLUDED_LOG = registerBlock("secluded_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_SECLUDED_LOG = registerBlock("stripped_secluded_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));

    public static final DeferredBlock<Block> SECLUDED_WOOD = registerBlock("secluded_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_SECLUDED_WOOD = registerBlock("stripped_secluded_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));


    public static final DeferredBlock<Block> SECLUDED_GRASS_BLOCK = registerBlock("secluded_grass_block",
            () -> new GrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)));


    public static final DeferredBlock<Block> SECLUDED_PLANKS = registerBlock("secluded_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                //we use a regular block, but override some methods in the block itself to create a flammable block
                //could also be done in a custom class but i only have the 1 plank so its not a problem
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final DeferredBlock<Block> SECLUDED_LEAVES = registerBlock("secluded_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }


            });

    public static final DeferredBlock<Block> SECLUDED_SAPLING = registerBlock("secluded_sapling",
            () -> new SaplingBlock(ModTreeGrowers.SECLUDED, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));



    public static <T extends Block>DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
