package com.yeetmanlord.somanyenchants.data.server;

import com.yeetmanlord.somanyenchants.SoManyEnchants;
import com.yeetmanlord.somanyenchants.common.enchantments.EffectEnchantment;
import com.yeetmanlord.somanyenchants.core.init.EnchantmentInit;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.RegistryObject;

public class LanguageProvider extends net.minecraftforge.common.data.LanguageProvider {

	public LanguageProvider(DataGenerator gen, String locale) {
		super(gen, SoManyEnchants.MOD_ID, locale);
	}

	@Override
	protected void addTranslations() {
		for (RegistryObject<Enchantment> entry : EnchantmentInit.ENCHANTMENTS.getEntries()) {
			Enchantment ench = entry.get();
			if (ench instanceof EffectEnchantment) {
				String name = entry.getId().getPath();
				name = name.replace("_", " ");
				add(ench, toTitleCase(name));
				add("so_many_enchants.screen.config.max_level." + toCammelCase(name),
						toTitleCase(name) + " | Max Level");
			}
		}
	}

	private String toTitleCase(String name) {
		String title = "";
		String[] parts = name.split(" ");
		for (String s : parts) {
			String first = String.valueOf(s.charAt(0));
			s = s.replaceFirst(first, first.toUpperCase());
			title += s + " ";
		}
		title = title.strip();
		return title;
	}

	private String toCammelCase(String name) {
		String cammel = "";
		String[] parts = name.split(" ");
		for (String s : parts) {
			String first = String.valueOf(s.charAt(0));
			s = s.replaceFirst(first, first.toUpperCase());
			cammel += s;
		}
		cammel = cammel.replaceFirst(String.valueOf(cammel.charAt(0)), String.valueOf(cammel.charAt(0)).toLowerCase());
		cammel = cammel.strip();
		return cammel;
	}

}
