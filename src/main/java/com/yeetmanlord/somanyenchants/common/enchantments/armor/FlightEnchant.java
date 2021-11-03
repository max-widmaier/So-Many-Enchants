package com.yeetmanlord.somanyenchants.common.enchantments.armor;

import com.yeetmanlord.somanyenchants.core.config.Config;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

public class FlightEnchant extends Enchantment 
{
	public FlightEnchant(Rarity rarityIn, EquipmentSlotType... slots)
	{
		super(rarityIn, EnchantmentType.ARMOR_FEET, slots);
	}
	
	@Override
	public boolean canVillagerTrade()
	{
		return false;
	}
	
	@Override
	public boolean isTreasureEnchantment() 
	{
		return true;
		
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack)
	{
		return false;
	}
	
	@Override
	public boolean canApply(ItemStack stack) 
	{
		return EnchantmentType.ARMOR_FEET.canEnchantItem(stack.getItem());
	}
	
	public boolean canApplyTogether(Enchantment ench)
	{
	      return super.canApplyTogether(ench) && ench != Enchantments.SOUL_SPEED;
	} 
	
	public int getMinEnchantability(int enchantmentLevel) 
	{
		return enchantmentLevel * 10;
	}

	public int getMaxEnchantability(int enchantmentLevel) 
	{
		return this.getMinEnchantability(enchantmentLevel) + 15;
	}
	
	@Override
	public int getMaxLevel()
	{
		if(Config.fl.isEnabled.get() == false)
		 {
			 return 0;
		 }
		 else return Config.fl.maxLevel.get();
	}
	
	@Override
	public boolean canGenerateInLoot() 
	{
		return false;
	}
	
	@Override
	public boolean isAllowedOnBooks()
	{
		return true;
	}
}
