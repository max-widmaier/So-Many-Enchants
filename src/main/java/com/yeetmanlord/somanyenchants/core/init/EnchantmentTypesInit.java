package com.yeetmanlord.somanyenchants.core.init;

import com.yeetmanlord.somanyenchants.common.blocks.EnchantedShulkerBoxBlock;
import com.yeetmanlord.somanyenchants.common.blocks.override.OverridenShulkerBoxBlock;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class EnchantmentTypesInit {

	public static final EnchantmentType HOPPER = EnchantmentType.create("hopper", item -> item.equals(Items.HOPPER));

	public static final EnchantmentType TRAPPED_CHEST = EnchantmentType.create("trapped_chest",
			item -> item.equals(Items.TRAPPED_CHEST));

	public static final EnchantmentType STORAGE = EnchantmentType.create("storage_blocks", item -> isStorage(item));

	public static final EnchantmentType SMELTER = EnchantmentType.create("smelting_blocks", item -> isSmelter(item));

	public static boolean isStorage(Item item) {
		if (item instanceof BlockItem) {
			BlockItem blockItem = (BlockItem) item;
			Block block = blockItem.getBlock();
			if (block instanceof OverridenShulkerBoxBlock || block instanceof EnchantedShulkerBoxBlock) {
				return true;
			} else if (item == Items.CHEST || item == Items.TRAPPED_CHEST || item == Items.BARREL) {
				return true;
			}
		}
		return false;
	};

	public static boolean isSmelter(Item item) {
		if (item instanceof BlockItem) {
			BlockItem blockItem = (BlockItem) item;
			Block block = blockItem.getBlock();
			if (block == Blocks.FURNACE || block == Blocks.SMOKER || block == Blocks.BLAST_FURNACE) {
				return true;
			}
		}
		return false;
	}

	public static boolean isModdedEnchantable(Item item) {
		return (EnchantmentTypesInit.HOPPER.canEnchantItem(item) || EnchantmentTypesInit.STORAGE.canEnchantItem(item)
				|| EnchantmentTypesInit.TRAPPED_CHEST.canEnchantItem(item)) && item != Items.AIR;
	}

}