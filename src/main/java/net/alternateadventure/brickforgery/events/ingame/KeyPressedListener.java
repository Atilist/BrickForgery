package net.alternateadventure.brickforgery.events.ingame;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.keyboard.KeyStateChangedEvent;

public class KeyPressedListener {

    @EventListener
    public void keyPressed(KeyStateChangedEvent event) {
        /*
        if (Keyboard.getEventKeyState() && Keyboard.isKeyDown(KeyBindingListener.keyBinding.key)) {
            ((Minecraft) FabricLoader.getInstance().getGameInstance()).player.increaseStat(AchievementListener.achievement, 1);
        }
        if (Keyboard.getEventKeyState() && Keyboard.isKeyDown(KeyBindingListener.keyBinding2.key)) {
            ((Minecraft)FabricLoader.getInstance().getGameInstance()).player.increaseStat(AchievementListener.achievement2, 1);
        }
        if (Keyboard.getEventKeyState() && Keyboard.isKeyDown(KeyBindingListener.keyBinding3.key)) {
            ((Minecraft) FabricLoader.getInstance().getGameInstance()).player.damage(null, 1000000);
        }

         */
    }
}
