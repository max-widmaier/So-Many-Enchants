package com.yeetmanlord.somanyenchants.core.config.vanilla_enchantments;

import com.yeetmanlord.somanyenchants.core.config.EnchantmentConfig;

import net.minecraftforge.common.ForgeConfigSpec.Builder;

public class Thorns extends EnchantmentConfig
{
	
	public Thorns(int absMax) {
		super(absMax);
		// TODO Auto-generated constructor stub
	}


	protected static String name = "Thorns";
	protected static int max = 10;
	protected static int vanilla = 3;
	
	
	public void init(Builder builder) 
	{
		builder.push(name);
		
		this.isEnabled = builder
				.comment(" Whether the mod changes this enchantment")
				.define("isEnabled", true);
		
		this.maxLevel = builder
				.comment(" The maximum enchantment level")
				.defineInRange("maxLevel", max, 1, 10);
		
		builder.pop();
	}
}
