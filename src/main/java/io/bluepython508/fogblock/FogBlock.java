package io.bluepython508.fogblock;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.options.KeyBinding;
import org.lwjgl.glfw.GLFW;

public class FogBlock implements ClientModInitializer {
	private final KeyBinding KEY = KeyBindingHelper.registerKeyBinding(new KeyBinding("Block Fog", GLFW.GLFW_KEY_H, "FogBlock"));

	public static boolean BLOCK_FOG = false;

	@Override
	public void onInitializeClient() {
		ClientTickEvents.END_CLIENT_TICK.register(minecraftClient -> {
			if (KEY.wasPressed()) {
				BLOCK_FOG = !BLOCK_FOG;
				if (minecraftClient.player == null) return;
				if (BLOCK_FOG) {
					minecraftClient.player.sendChatMessage("Blocking fog");
				} else {
					minecraftClient.player.sendChatMessage("Not blocking fog");
				}
			}
		});
	}
}
