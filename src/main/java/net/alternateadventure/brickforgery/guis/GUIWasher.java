package net.alternateadventure.brickforgery.guis;

import net.alternateadventure.brickforgery.containers.ContainerCrusher;
import net.alternateadventure.brickforgery.containers.ContainerWasher;
import net.alternateadventure.brickforgery.tileentities.TileEntityCrusher;
import net.alternateadventure.brickforgery.tileentities.TileEntityWasher;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.container.ContainerBase;
import net.minecraft.entity.player.PlayerInventory;
import org.lwjgl.opengl.GL11;

@Environment(EnvType.CLIENT)
public class GUIWasher extends ContainerBase {
    private TileEntityWasher washer;

    public GUIWasher(PlayerInventory arg, TileEntityWasher arg2) {
        super(new ContainerWasher(arg, arg2));
        this.washer = arg2;
    }

    protected void renderForeground() {
        this.textManager.drawText("Washer", 60, 6, 4210752);
        this.textManager.drawText("Inventory", 8, this.containerHeight - 96 + 2, 4210752);
    }

    protected void renderContainerBackground(float f) {
        int var2 = this.minecraft.textureManager.getTextureId("/assets/brickforgery/stationapi/gui/washer.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.textureManager.bindTexture(var2);
        int var3 = (this.width - this.containerWidth) / 2;
        int var4 = (this.height - this.containerHeight) / 2;
        this.blit(var3, var4, 0, 0, this.containerWidth, this.containerHeight);
        int var5;
        var5 = this.washer.getProcessingTimeDelta(24);
        this.blit(var3 + 79, var4 + 34, 176, 14, var5 + 1, 16);
    }
}

