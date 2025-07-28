package net.fastandfurious.vroomcraft.fluid;

import net.fastandfurious.vroomcraft.VroomCraft;
import net.fastandfurious.vroomcraft.blocks.ModBlocks;
import net.fastandfurious.vroomcraft.items.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(Registries.FLUID, VroomCraft.MODID);

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, VroomCraft.MODID);


    public static void register(IEventBus bus)
    {
        FLUIDS.register(bus);
        FLUID_TYPES.register(bus);
    }

    // Fluid Type
    public static final Supplier<FluidType> ALUMINUM_FLUID_TYPE = FLUID_TYPES.register("aluminum_fluid",
            () -> new FluidType(FluidType.Properties.create()
                    .density(1500)
                    .viscosity(2000)
                    .temperature(300)
                    .canDrown(true)
                    .lightLevel(4)));



    // Still Fluid
    public static final Supplier<FlowingFluid> ALUMINUM_FLUID = FLUIDS.register("aluminum_fluid",
            () -> new BaseFlowingFluid.Source(ModFluids.ALUMINUM_PROPERTIES));

    // Flowing Fluid
    public static final Supplier<FlowingFluid> ALUMINUM_FLOWING = FLUIDS.register("aluminum_flowing",
            () -> new BaseFlowingFluid.Flowing(ModFluids.ALUMINUM_PROPERTIES));

    // Properties
    public static final BaseFlowingFluid.Properties ALUMINUM_PROPERTIES = new BaseFlowingFluid.Properties(
            ALUMINUM_FLUID_TYPE, ALUMINUM_FLUID, ALUMINUM_FLOWING)
            .block(ModBlocks.ALUMINUM_FLUID_BLOCK)
            .bucket(ModItems.ALUMINUM_BUCKET);
}
