package net.alternateadventure.brickforgery.guis;

import net.alternateadventure.brickforgery.containers.ContainerCrusher;
import net.alternateadventure.brickforgery.containers.ContainerMetalworkingStation;
import net.alternateadventure.brickforgery.tileentities.TileEntityCrusher;
import net.alternateadventure.brickforgery.tileentities.TileEntityMetalworkingStation;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.container.ContainerBase;
import net.minecraft.entity.player.PlayerInventory;
import org.lwjgl.opengl.GL11;

@Environment(EnvType.CLIENT)
public class GUICrusher extends ContainerBase {
    private TileEntityCrusher crusher;

    public GUICrusher(PlayerInventory arg, TileEntityCrusher arg2) {
        super(new ContainerCrusher(arg, arg2));
        this.crusher = arg2;
    }

    protected void renderForeground() {
        this.textManager.drawText("Crusher", 60, 6, 4210752);
        this.textManager.drawText("Inventory", 8, this.containerHeight - 96 + 2, 4210752);
    }

    protected void renderContainerBackground(float f) {
        int var2 = this.minecraft.textureManager.getTextureId("/assets/brickforgery/stationapi/gui/crusher.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.textureManager.bindTexture(var2);
        int var3 = (this.width - this.containerWidth) / 2;
        int var4 = (this.height - this.containerHeight) / 2;
        this.blit(var3, var4, 0, 0, this.containerWidth, this.containerHeight);
        int var5;
        var5 = this.crusher.getCrushingTimeDelta(24);
        this.blit(var3 + 79, var4 + 34, 176, 14, var5 + 1, 16);
    }
}
