package rest_anywhere.example.mixin.client;

import net.minecraft.client.input.Input;
import net.minecraft.client.input.KeyboardInput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rest_anywhere.example.RestAnywhereClient;

@Mixin(KeyboardInput.class)
public class KeyboardInputMixin extends Input {

	@Inject(method = "tick", at = @At("TAIL"))
	private void tick(boolean slowDown, float f, CallbackInfo ci) {
		// 只在坐下时禁止输入
		if (RestAnywhereClient.isSitting()) {
			// 强制清空移动输入
			this.movementForward = 0.0F;
			this.movementSideways = 0.0F;
			this.jumping = false;
			this.sneaking = false;
		}
	}
}