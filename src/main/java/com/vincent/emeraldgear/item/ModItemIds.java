package com.vincent.emeraldgear.item;

import com.vincent.emeraldgear.EmeraldGear;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItemIds {
    public static ResourceKey<Item> create(String name) {
        return ResourceKey.create(
                Registries.ITEM,
                Identifier.fromNamespaceAndPath(EmeraldGear.MOD_ID, name));
    }

    // Armor
    public static final ResourceKey<Item> EMERALD_HELMET     = create("emerald_helmet");
    public static final ResourceKey<Item> EMERALD_CHESTPLATE = create("emerald_chestplate");
    public static final ResourceKey<Item> EMERALD_LEGGINGS   = create("emerald_leggings");
    public static final ResourceKey<Item> EMERALD_BOOTS      = create("emerald_boots");

    // Tools
    public static final ResourceKey<Item> EMERALD_SWORD   = create("emerald_sword");
    public static final ResourceKey<Item> EMERALD_PICKAXE = create("emerald_pickaxe");
    public static final ResourceKey<Item> EMERALD_AXE     = create("emerald_axe");
    public static final ResourceKey<Item> EMERALD_SHOVEL  = create("emerald_shovel");
    public static final ResourceKey<Item> EMERALD_HOE     = create("emerald_hoe");
}

