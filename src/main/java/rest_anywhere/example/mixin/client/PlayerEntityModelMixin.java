package rest_anywhere.example.mixin.client;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rest_anywhere.example.RestAnywhereClient;

@Mixin(PlayerEntityModel.class)
public abstract class PlayerEntityModelMixin<T extends LivingEntity> extends BipedEntityModel<T> {

	@Shadow @Final public ModelPart leftSleeve;
	@Shadow @Final public ModelPart rightSleeve;
	@Shadow @Final public ModelPart leftPants;
	@Shadow @Final public ModelPart rightPants;
	@Shadow @Final public ModelPart jacket;

	public PlayerEntityModelMixin(ModelPart root) {
		super(root);
	}

	@Inject(method = "setAngles", at = @At("TAIL"))
	public void setAngles(T livingEntity, float f, float g, float h, float i, float j, CallbackInfo ci) {
		if (livingEntity.getUuid().equals(net.minecraft.client.MinecraftClient.getInstance().player.getUuid())) {
			
			// --- 大头模式逻辑 ---
			if (RestAnywhereClient.isBigHead()) {
				float scale = 3.0F; // 放大3倍
				this.head.xScale = scale;
				this.head.yScale = scale;
				this.head.zScale = scale;
				
				this.hat.xScale = scale;
				this.hat.yScale = scale;
				this.hat.zScale = scale;
			} else {
				// 重置回正常大小
				this.head.xScale = 1.0F;
				this.head.yScale = 1.0F;
				this.head.zScale = 1.0F;
				
				this.hat.xScale = 1.0F;
				this.hat.yScale = 1.0F;
				this.hat.zScale = 1.0F;
			}

			// --- 坐下/趴下逻辑 ---
			if (RestAnywhereClient.isSitting()) {
				// 下移偏移量
				float offset = 11.0F;

				// 1. 身体部件 (Body, Jacket)
				this.body.pivotY = 0.0F + offset;
				this.jacket.pivotY = 0.0F + offset;

				// 2. 头部部件 (Head, Hat)
				this.head.pivotY = 0.0F + offset;
				this.hat.pivotY = 0.0F + offset;

				// 3. 手臂部件 (Arm, Sleeve)
				this.leftArm.pivotY = 2.0F + offset;
				this.leftSleeve.pivotY = 2.0F + offset;
				this.rightArm.pivotY = 2.0F + offset;
				this.rightSleeve.pivotY = 2.0F + offset;

				// 4. 腿部部件 (Leg, Pants)
				this.leftLeg.pivotY = 12.0F + offset;
				this.leftPants.pivotY = 12.0F + offset;
				this.rightLeg.pivotY = 12.0F + offset;
				this.rightPants.pivotY = 12.0F + offset;

				// 5. 设置腿部旋转 (坐姿)
				this.leftLeg.pitch = -1.5707964f; // -90度
				this.leftPants.pitch = -1.5707964f;
				
				this.rightLeg.pitch = -1.5707964f;
				this.rightPants.pitch = -1.5707964f;

				// 微调开合
				this.leftLeg.yaw = -0.1f;
				this.leftPants.yaw = -0.1f;
				this.rightLeg.yaw = 0.1f;
				this.rightPants.yaw = 0.1f;

			} else {
				// 理论上不需要手动重置，因为 setAngles 开头会重置
				// 但如果发现问题，可以在这里强制重置回默认值
			}
		}
	}
}