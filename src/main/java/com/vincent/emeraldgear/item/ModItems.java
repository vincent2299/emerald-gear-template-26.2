package com.vincent.emeraldgear.item;

import java.util.function.Function;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.equipment.ArmorType;

public class ModItems {
    public static Item register(ResourceKey<Item> itemKey,
                                Function<Item.Properties, Item> itemFactory,
                                Item.Properties settings) {
        Item item = itemFactory.apply(settings.setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return item;
    }

    // ---- Armor ----
    // ArmorMaterial doesn't carry durability, so each piece computes its own
    // from the base value.
    public static final Item EMERALD_HELMET = register(
            ModItemIds.EMERALD_HELMET,
            Item::new,
            new Item.Properties()
                    .humanoidArmor(EmeraldArmorMaterial.INSTANCE, ArmorType.HELMET)
                    .durability(ArmorType.HELMET.getDurability(EmeraldArmorMaterial.BASE_DURABILITY))
    );

    public static final Item EMERALD_CHESTPLATE = register(
            ModItemIds.EMERALD_CHESTPLATE,
            Item::new,
            new Item.Properties()
                    .humanoidArmor(EmeraldArmorMaterial.INSTANCE, ArmorType.CHESTPLATE)
                    .durability(ArmorType.CHESTPLATE.getDurability(EmeraldArmorMaterial.BASE_DURABILITY))
    );

    public static final Item EMERALD_LEGGINGS = register(
            ModItemIds.EMERALD_LEGGINGS,
            Item::new,
            new Item.Properties()
                    .humanoidArmor(EmeraldArmorMaterial.INSTANCE, ArmorType.LEGGINGS)
                    .durability(ArmorType.LEGGINGS.getDurability(EmeraldArmorMaterial.BASE_DURABILITY))
    );

    public static final Item EMERALD_BOOTS = register(
            ModItemIds.EMERALD_BOOTS,
            Item::new,
            new Item.Properties()
                    .humanoidArmor(EmeraldArmorMaterial.INSTANCE, ArmorType.BOOTS)
                    .durability(ArmorType.BOOTS.getDurability(EmeraldArmorMaterial.BASE_DURABILITY))
    );

    // ---- Tools ----
    // Swords and pickaxes are plain Items configured through Item.Properties.
    public static final Item EMERALD_SWORD = register(
            ModItemIds.EMERALD_SWORD,
            Item::new,
            new Item.Properties().sword(ModToolMaterials.EMERALD, 3.0F, -2.4F)
    );

    public static final Item EMERALD_PICKAXE = register(
            ModItemIds.EMERALD_PICKAXE,
            Item::new,
            new Item.Properties().pickaxe(ModToolMaterials.EMERALD, 1.0F, -2.8F)
    );

    // Axes, shovels and hoes need their own classes — they carry right-click
    // behaviour (stripping logs, making paths, tilling soil).
    public static final Item EMERALD_AXE = register(
            ModItemIds.EMERALD_AXE,
            settings -> new AxeItem(ModToolMaterials.EMERALD, 5.0F, -3.0F, settings),
            new Item.Properties()
    );

    public static final Item EMERALD_SHOVEL = register(
            ModItemIds.EMERALD_SHOVEL,
            settings -> new ShovelItem(ModToolMaterials.EMERALD, 1.5F, -3.0F, settings),
            new Item.Properties()
    );

    public static final Item EMERALD_HOE = register(
            ModItemIds.EMERALD_HOE,
            settings -> new HoeItem(ModToolMaterials.EMERALD, -1.0F, 0.0F, settings),
            new Item.Properties()
    );

    public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
                .register(tab -> {
                    tab.accept(EMERALD_HELMET);
                    tab.accept(EMERALD_CHESTPLATE);
                    tab.accept(EMERALD_LEGGINGS);
                    tab.accept(EMERALD_BOOTS);
                    tab.accept(EMERALD_SWORD);
                });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register(tab -> {
                    tab.accept(EMERALD_PICKAXE);
                    tab.accept(EMERALD_AXE);
                    tab.accept(EMERALD_SHOVEL);
                    tab.accept(EMERALD_HOE);
                });
    }
}