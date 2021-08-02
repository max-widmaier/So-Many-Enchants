package com.yeetmanlord.enchantsplus.common.enchantments;

import com.yeetmanlord.enchantsplus.core.init.EnchantmentInit;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

public class BlockReach extends Enchantment
{
	public BlockReach(Rarity rarityIn, EquipmentSlotType... slots)
	{
		super(rarityIn, EnchantmentType.DIGGER, slots);
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) 
	{
		return EnchantmentType.DIGGER.canEnchantItem(stack.getItem());
	}
	
	@Override
	public boolean canApply(ItemStack stack) 
	{
		return EnchantmentType.DIGGER.canEnchantItem(stack.getItem());
	}
	
	@Override
	public int getMaxLevel() 
	{
		return 3;
	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel)
	{
		return 10 + (enchantmentLevel - 1) * 10;
	}
	
	@Override
	public int getMaxEnchantability(int enchantmentLevel)
	{
		return this.getMinEnchantability(enchantmentLevel) + 15;
	}
	
	@Override
	protected boolean canApplyTogether(Enchantment ench) 
	{
		return super.canApplyTogether(ench) && ench != EnchantmentInit.ATTACK_REACH.get();
	}
}