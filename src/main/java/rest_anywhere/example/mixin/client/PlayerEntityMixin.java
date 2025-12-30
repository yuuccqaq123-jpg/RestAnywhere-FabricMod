package rest_anywhere.example.mixin.client;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rest_anywhere.example.RestAnywhereClient;

@Mixin(Entity.class)
public class PlayerEntityMixin {
	@Inject(method = "getPose", at = @At("HEAD"), cancellable = true)
	private void getPose(CallbackInfoReturnable<EntityPose> cir) {
		if ((Object) this instanceof ClientPlayerEntity) {
			if (RestAnywhereClient.isSitting()) {
				cir.setReturnValue(EntityPose.SITTING);
			} else if (RestAnywhereClient.isLying()) {
				cir.setReturnValue(EntityPose.SWIMMING);
			}
		}
	}

	// 使用精确的方法描述符来注入
	@Inject(method = "getEyeHeight(Lnet/minecraft/entity/EntityPose;Lnet/minecraft/entity/EntityDimensions;)F", at = @At("HEAD"), cancellable = true)
	private void getEyeHeight(EntityPose pose, EntityDimensions dimensions, CallbackInfoReturnable<Float> cir) {
		if ((Object) this instanceof ClientPlayerEntity) {
			if (RestAnywhereClient.isSitting()) {
				cir.setReturnValue(1.15F);
			} else if (RestAnywhereClient.isLying()) {
				cir.setReturnValue(0.4F);
			}
		}
	}
}
