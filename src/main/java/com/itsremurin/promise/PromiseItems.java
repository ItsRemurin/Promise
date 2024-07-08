package com.itsremurin.promise;

import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class PromiseItems {
    public static final Item WITHER_BONE = register("wither_bone", new Item(new Item.Settings()));
    //public static final Item WITHER_BONE_MEAL = register("wither_bone_meal", new BoneMealItem(new Item.Settings()));
    //public static final Item WITHER_BONE_BLOCK = register(Blocks.BONE_BLOCK);

    public static Item register(String id, Item item) {
        return register(Identifier.of(PromiseMod.MOD_ID, id), item);
    }

    public static Item register(Identifier id, Item item) {
        return register(RegistryKey.of(Registries.ITEM.getKey(), id), item);
    }

    public static Item register(RegistryKey<Item> key, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
        return Registry.register(Registries.ITEM, key, item);
    }

    public static void Init() {}
}
