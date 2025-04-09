package net.alternateadventure.brickforgery.guis;

import net.alternateadventure.brickforgery.containers.WasherScreenHandler;
import net.alternateadventure.brickforgery.tileentities.TileEntityWasher;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import org.lwjgl.opengl.GL11;

@Environment(EnvType.CLIENT)
public class WasherScreen extends HandledScreen {
    private final TileEntityWasher washer;

    public WasherScreen(PlayerInventory arg, TileEntityWasher arg2) {
        super(new WasherScreenHandler(arg, arg2));
        this.washer = arg2;
    }

    @Override
    protected void drawForeground() {
        this.textRenderer.draw("Washer", 60, 6, 4210752);
        this.textRenderer.draw("Inventory", 8, this.backgroundHeight - 96 + 2, 4210752);
    }

    @Override
    protected void drawBackground(float f) {
        int var2 = this.minecraft.textureManager.getTextureId("/assets/brickforgery/stationapi/gui/washer.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.textureManager.bindTexture(var2);
        int var3 = (this.width - this.backgroundWidth) / 2;
        int var4 = (this.height - this.backgroundHeight) / 2;
        this.drawTexture(var3, var4, 0, 0, this.backgroundWidth, this.backgroundHeight);
        int var5;
        var5 = this.washer.getProcessingTimeDelta(24);
        this.drawTexture(var3 + 79, var4 + 34, 176, 14, var5 + 1, 16);
    }
}

