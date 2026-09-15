package com.vincent.emeraldgear.item;

import java.util.Map;

import com.vincent.emeraldgear.EmeraldGear;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

public class EmeraldArmorMaterial {
    // Multiplied per-slot to get each piece's real durability.
    // Vanilla reference: iron 15, diamond 33.
    public static final int BASE_DURABILITY = 20;

    // Items that can repair emerald gear in an anvil. Tools reuse this too.
    public static final TagKey<Item> REPAIRS_EMERALD_ARMOR = TagKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(EmeraldGear.MOD_ID, "repairs_emerald_armor"));

    // Tells the game where to find the worn-armor textures.
    // The path segment here ("emerald") becomes the filename of your equipment JSON.
    public static final ResourceKey<EquipmentAsset> EMERALD_ARMOR_ASSET = ResourceKey.create(
            EquipmentAssets.ROOT_ID,
            Identifier.fromNamespaceAndPath(EmeraldGear.MOD_ID, "emerald"));

    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.HELMET, 3,
                    ArmorType.CHESTPLATE, 7,
                    ArmorType.LEGGINGS, 5,
                    ArmorType.BOOTS, 2
            ),
            14,                              // enchantability
            SoundEvents.ARMOR_EQUIP_DIAMOND, // equip sound
            1.0F,                            // toughness
            0.0F,                            // knockback resistance
            REPAIRS_EMERALD_ARMOR,
            EMERALD_ARMOR_ASSET
    );
}