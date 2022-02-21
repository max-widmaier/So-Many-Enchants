package com.yeetmanlord.somanyenchants.mixins.enchants;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.yeetmanlord.somanyenchants.core.config.Config;

import net.minecraft.world.item.enchantment.KnockbackEnchantment;

@Mixin(KnockbackEnchantment.class)
public class MixinKnockbackEnchantment {
	@Inject(at = @At("HEAD"), method = "getMaxLevel()I", cancellable = true)
	private void getMaxLevel(CallbackInfoReturnable<Integer> callback) {
		if (Config.knockback.isEnabled.get() == false) {
			callback.setReturnValue(2);
		} else
			callback.setReturnValue(Config.knockback.maxLevel.get());
	}
}