package rest_anywhere.example.mixin.client;

import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rest_anywhere.example.RestAnywhereClient;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {
	@Inject(method = "tickMovement", at = @At("HEAD"))
	private void tickMovement(CallbackInfo ci) {
		ClientPlayerEntity player = (ClientPlayerEntity) (Object) this;
		// 只在坐下时限制速度
		if (RestAnywhereClient.isSitting()) {
			// 物理上限制水平速度，但保留垂直速度（重力）
			player.setVelocity(0, player.getVelocity().y, 0);
		}
	}
}