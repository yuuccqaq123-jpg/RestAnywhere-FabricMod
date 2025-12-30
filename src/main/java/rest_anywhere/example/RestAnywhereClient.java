package rest_anywhere.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class RestAnywhereClient implements ClientModInitializer {

	private static KeyBinding sitKeyBinding;
	private static KeyBinding lieKeyBinding;
	private static KeyBinding bigHeadKeyBinding;

	private static boolean isSitting = false;
	private static boolean isLying = false;
	private static boolean isBigHead = false;

	@Override
	public void onInitializeClient() {
		sitKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.rest_anywhere.sit",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_C,
				"category.rest_anywhere.rest"
		));

		lieKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.rest_anywhere.lie",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_Z,
				"category.rest_anywhere.rest"
		));

		bigHeadKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.rest_anywhere.big_head",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_V,
				"category.rest_anywhere.rest"
		));

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (client.player == null) return;

			if (sitKeyBinding.wasPressed()) {
				isSitting = !isSitting;
				if (isSitting) {
					isLying = false;
					client.player.sendMessage(Text.literal("You are now sitting."), false);
				} else {
					client.player.sendMessage(Text.literal("You stood up."), false);
				}
				// 强制刷新玩家尺寸和眼睛高度 (Yarn Mappings)
				client.player.calculateDimensions();
			}

			if (lieKeyBinding.wasPressed()) {
				isLying = !isLying;
				if (isLying) {
					isSitting = false;
					client.player.sendMessage(Text.literal("You are now lying down (crawling)."), false);
				} else {
					client.player.sendMessage(Text.literal("You stood up."), false);
				}
				// 强制刷新玩家尺寸和眼睛高度 (Yarn Mappings)
				client.player.calculateDimensions();
			}

			if (bigHeadKeyBinding.wasPressed()) {
				isBigHead = !isBigHead;
				client.player.sendMessage(Text.literal("Big Head Mode: " + (isBigHead ? "ON" : "OFF")), false);
			}
		});
	}

	public static boolean isSitting() {
		return isSitting;
	}

	public static boolean isLying() {
		return isLying;
	}

	public static boolean isBigHead() {
		return isBigHead;
	}
}
