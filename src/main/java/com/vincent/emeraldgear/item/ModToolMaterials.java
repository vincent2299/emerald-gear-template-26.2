package com.vincent.emeraldgear.item;

import com.vincent.emeraldgear.EmeraldGear;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.block.Block;

public class ModToolMaterials {
    // Blocks in this tag will NOT drop when mined with emerald tools.
    public static final TagKey<Block> INCORRECT_FOR_EMERALD_TOOL = TagKey.create(
            Registries.BLOCK,
            Identifier.fromNamespaceAndPath(EmeraldGear.MOD_ID, "incorrect_for_emerald_tool"));

    public static final ToolMaterial EMERALD = new ToolMaterial(
            INCORRECT_FOR_EMERALD_TOOL,
            1100,  // durability      (iron 250, diamond 1561)
            7.0F,  // mining speed    (iron 6.0, diamond 8.0)
            2.5F,  // attack bonus    (iron 2.0, diamond 3.0)
            14,    // enchantability
            EmeraldArmorMaterial.REPAIRS_EMERALD_ARMOR
    );
}