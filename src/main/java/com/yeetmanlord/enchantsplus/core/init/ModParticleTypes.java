package com.yeetmanlord.enchantsplus.core.init;

import com.yeetmanlord.enchantsplus.Main;

import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModParticleTypes 
{

	public static final DeferredRegister<ParticleType<?>> 
	PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Main.MOD_ID);
	
	public static final RegistryObject<ParticleType<?>> FREEZE_PARTICLE = PARTICLES.register("freeze", () -> new BasicParticleType(false));

}
