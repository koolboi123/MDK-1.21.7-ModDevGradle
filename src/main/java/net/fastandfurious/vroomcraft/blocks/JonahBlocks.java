package net.fastandfurious.vroomcraft.blocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

public class JonahBlocks
{

    public static final DeferredBlock<Block> BLOCK_OF_RUBBER = ModBlocks.registerBlock("block_of_rubber",() -> new Block(BlockBehaviour.Properties.of()
            .strength(0.1f, 100f)
            .sound(SoundType.SLIME_BLOCK)
            .requiresCorrectToolForDrops()
            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("vroomcraft:block_of_rubber")))));
}

