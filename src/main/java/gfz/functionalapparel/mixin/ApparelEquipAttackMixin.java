package gfz.functionalapparel.mixin;

import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import gfz.functionalapparel.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// Inspired by: https://github.com/JSJBDEV/GiveMeHats/blob/master/src/main/java/gd/rf/acro/givemehats/mixin/AttackMixin.java
@Mixin(LivingEntity.class)
public abstract class ApparelEquipAttackMixin {
    @Inject(method = "damage", at = @At("TAIL"))
    private void damage(DamageSource source, float amount, CallbackInfoReturnable cir) {
        if (source.getAttacker() instanceof ServerPlayerEntity) {
            PlayerEntity player = (PlayerEntity) source.getAttacker();
            TrinketComponent component = TrinketsApi.getTrinketComponent(player).get();

            if(component.isEquipped(ModItems.BLOODSOAKED_BOW)) {
                player.heal(1);
            }
        }
    }
}
