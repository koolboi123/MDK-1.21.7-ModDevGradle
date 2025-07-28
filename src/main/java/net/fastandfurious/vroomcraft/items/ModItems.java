package net.fastandfurious.vroomcraft.items;

import net.fastandfurious.vroomcraft.VroomCraft;
import net.fastandfurious.vroomcraft.fluid.ModFluids;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(VroomCraft.MODID);
    public static void register(IEventBus bus)
    {
        ITEMS.register(bus);
    }

    public static final DeferredItem <Item> RAW_RUBBER = ITEMS.register("raw_rubber",
            ()->new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse("vroomcraft:raw_rubber")))));

    public static final DeferredItem <Item> BUCKET_OF_OIL = ITEMS.register("bucket_of_oil",
            ()->new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse("vroomcraft:bucket_of_oil")))));

    public static final DeferredItem <Item> PLASTIC_PICKAXE = ITEMS.register("plastic_pickaxe",
            ()->new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse("vroomcraft:plastic_pickaxe")))));

    public static final DeferredItem<Item> ALUMINUM_BUCKET = ITEMS.register("aluminum_bucket",
            () -> new BucketItem(ModFluids.ALUMINUM_FLUID.get(),
                    new Item.Properties()
                            .craftRemainder(Items.BUCKET)
                            .stacksTo(1)
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse("vroomcraft:aluminum_bucket")))));

    public static final DeferredItem <Item> RAW_ALUMINUM = ITEMS.register("raw_aluminum",
            ()->new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse("vroomcraft:raw_aluminum")))));
    public static final DeferredItem <Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot",
            ()->new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse("vroomcraft:aluminum_ingot")))));
    public static final DeferredItem <Item> PLASTIC_WASTE = ITEMS.register("plastic_waste",
            ()->new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse("vroomcraft:plastic_waste")))));
}
