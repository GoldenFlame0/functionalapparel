package gfz.functionalapparel.item;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.client.TrinketRenderer;
import gfz.functionalapparel.FunctionalApparel;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;

import java.util.UUID;

public class BloodsoakedBow extends TrinketItem{
    public BloodsoakedBow(Settings settings) {
        super(settings);
    }
    
    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        var modifiers = super.getModifiers(stack, slot, entity, uuid);
        modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, new EntityAttributeModifier(uuid, "functionalapparel:maxhealth", 2, EntityAttributeModifier.Operation.ADDITION));
        return modifiers;
    }

    // TODO: Rendering world models.
//    @Override
//    public void render(
//            ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel,
//            MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity,
//            float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw,
//            float headPitch) {
//        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
//        TrinketRenderer.translateToFace(matrices, (PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, (AbstractClientPlayerEntity) entity, headYaw, headPitch);
//        matrices.scale(-1f,-1f,1f);
//        matrices.translate(0,0.7,0.3f);
//        itemRenderer.renderItem(stack, ModelTransformationMode.FIXED, light, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers,null, 0);
//    }
}
