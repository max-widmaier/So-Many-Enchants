package com.yeetmanlord.enchantsplus.common.enchantments.weapons;

import com.yeetmanlord.enchantsplus.core.init.EnchantmentInit;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;

public class CriticalEnchant extends Enchantment
{
	public CriticalEnchant(Rarity rarityIn, EquipmentSlotType... slots)
	{
		super(rarityIn, EnchantmentType.WEAPON, slots);
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) 
	{
		//return false;
		return EnchantmentType.WEAPON.canEnchantItem(stack.getItem()); //temp
	}
	
	@Override
	public boolean canApply(ItemStack stack) 
	{
		return stack.getItem() instanceof TridentItem || stack.getItem() instanceof AxeItem ? true : EnchantmentType.WEAPON.canEnchantItem(stack.getItem());
	}
	
	@Override
	public int getMaxLevel() 
	{
		return 5;
	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel) 
	{
		return 15 + (enchantmentLevel - 1) * 9;
	}

	@Override
	public int getMaxEnchantability(int enchantmentLevel) 
	{
		return super.getMinEnchantability(enchantmentLevel) + 50;
	}
	
	@Override
	protected boolean canApplyTogether(Enchantment ench) 
	{
		return super.canApplyTogether(ench) && ench != Enchantments.SWEEPING && ench != EnchantmentInit.FREEZING.get();
	}
	
	/*
	@Override
	public boolean canVillagerTrade() 
	{
		return false;
	} */
}
