package net.fastandfurious.vroomcraft.items;

import net.fastandfurious.vroomcraft.VroomCraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

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
}
