package net.fastandfurious.vroomcraft.blocks;

import net.fastandfurious.vroomcraft.VroomCraft;
import net.fastandfurious.vroomcraft.fluid.ModFluids;
import net.fastandfurious.vroomcraft.items.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(VroomCraft.MODID);
    public static void register(IEventBus bus)
    {
        BLOCKS.register(bus);
    }
    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse("vroomcraft:"+name)))));
    }

    public static final DeferredBlock <Block> BLOCK_OF_RAW_RUBBER = registerBlock("block_of_raw_rubber",() -> new Block(BlockBehaviour.Properties.of()
            .sound(SoundType.SLIME_BLOCK)
            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("vroomcraft:block_of_raw_rubber")))));

    public static final DeferredBlock <Block> ALUMINUM_ORE = registerBlock("aluminum_ore",() -> new Block(BlockBehaviour.Properties.of()
            .sound(SoundType.IRON)
            .strength(1.79f)
            .requiresCorrectToolForDrops()
            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("vroomcraft:aluminum_ore")))));

    public static final DeferredBlock<Block> BLOCK_OF_RUBBER = ModBlocks.registerBlock("block_of_rubber",() -> new Block(BlockBehaviour.Properties.of()
            .strength(0.1f, 100f)
            .sound(SoundType.SLIME_BLOCK)
            .requiresCorrectToolForDrops()
            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("vroomcraft:block_of_rubber")))));

    public static final Supplier<LiquidBlock> ALUMINUM_FLUID_BLOCK = BLOCKS.register("aluminum_fluid",
            () -> new LiquidBlock(ModFluids.ALUMINUM_FLOWING.get(),
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.METAL)
                            .replaceable()
                            .noCollission()
                            .strength(100.0F)
                            .pushReaction(PushReaction.DESTROY)
                            .noLootTable()
                            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("vroomcraft:aluminum_fluid")))));


}
