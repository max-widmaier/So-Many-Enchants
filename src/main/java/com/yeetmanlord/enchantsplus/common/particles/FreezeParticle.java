package com.yeetmanlord.enchantsplus.common.particles;

import javax.annotation.Nullable;

import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class FreezeParticle extends SpriteTexturedParticle 
{
	private FreezeParticle(ClientWorld world, double x, double y, double z, double motionX, double motionY, double motionZ) {
	      super(world, x, y, z, 0.0D, 0.0D, 0.0D);
	      this.motionX *= (double)0.1F;
	      this.motionY *= (double)0.1F;
	      this.motionZ *= (double)0.1F;
	      this.motionX += motionX * 0.4D;
	      this.motionY += motionY * 0.4D;
	      this.motionZ += motionZ * 0.4D;
	      float f = (float)(Math.random() * (double)0.3F + (double)0.6F);
	      this.particleRed = f;
	      this.particleGreen = f;
	      this.particleBlue = f;
	      this.particleScale *= 0.75F;
	      this.maxAge = Math.max((int)(6.0D / (Math.random() * 0.8D + 0.6D)), 1);
	      this.canCollide = false;
	      this.tick();
	   }

	   public float getScale(float scaleFactor) {
	      return this.particleScale * MathHelper.clamp(((float)this.age + scaleFactor) / (float)this.maxAge * 32.0F, 0.0F, 1.0F);
	   }

	   public void tick() {
	      this.prevPosX = this.posX;
	      this.prevPosY = this.posY;
	      this.prevPosZ = this.posZ;
	      if (this.age++ >= this.maxAge) {
	         this.setExpired();
	      } else {
	         this.move(this.motionX, this.motionY, this.motionZ);
	         this.particleGreen = (float)((double)this.particleGreen * 0.96D);
	         this.particleBlue = (float)((double)this.particleBlue * 0.9D);
	         this.motionX *= (double)0.7F;
	         this.motionY *= (double)0.7F;
	         this.motionZ *= (double)0.7F;
	         this.motionY -= (double)0.02F;
	         if (this.onGround) {
	            this.motionX *= (double)0.7F;
	            this.motionZ *= (double)0.7F;
	         }

	      }
	   }

	   public IParticleRenderType getRenderType() {
	      return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
	   }
	   
	   @OnlyIn(Dist.CLIENT)
	   public class Factory implements IParticleFactory<BasicParticleType>
	   {
		   @Nullable
		   @Override
	       public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
	    	  FreezeParticle freezeParticle = new FreezeParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
	    	  freezeParticle.setColor(1.0f, 1.0f, 1.0f);
	          return freezeParticle;
	       }
	   }
}