package com.kamth.zeldamod.entity.client.render.chu;

import com.kamth.zeldamod.ZeldaMod;
import com.kamth.zeldamod.entity.client.MobModelLayers;
import com.kamth.zeldamod.entity.client.model.ChuchuModel;
import com.kamth.zeldamod.entity.client.model.ChuchuOuterLayer;
import com.kamth.zeldamod.entity.mobs.hostile.chus.ChuchuEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.Mth;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Optional;

public class ChuchuRenderer extends MobRenderer<ChuchuEntity, ChuchuModel<ChuchuEntity>> {
    public ChuchuRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ChuchuModel<>(pContext.bakeLayer(MobModelLayers.CHUCHU_LAYER)), .2f);
      this.addLayer(new ChuchuOuterLayer<>(this, pContext.getModelSet()));

    }


    @Override
    public ResourceLocation getTextureLocation(ChuchuEntity pEntity) {
        ResourceManager resourceManager = Minecraft.getInstance().getResourceManager();


        ResourceLocation ChuTex = new ResourceLocation
                (ZeldaMod.MOD_ID, "textures/entity/mob/"  + ForgeRegistries.ENTITY_TYPES.getKey(pEntity.getType()).getPath() + ".png");


            return ChuTex;

    }

    @Override
    public void render(ChuchuEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {




        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
    protected void scale(ChuchuEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
        float f = 0.999F;
        pMatrixStack.scale(0.999F, 0.999F, 0.999F);
        pMatrixStack.translate(0.0F, 0.001F, 0.0F);
        float f1 = (float)pLivingEntity.getSize();
        float f2 = Mth.lerp(pPartialTickTime, pLivingEntity.oSquish, pLivingEntity.squish) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        pMatrixStack.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }

}
