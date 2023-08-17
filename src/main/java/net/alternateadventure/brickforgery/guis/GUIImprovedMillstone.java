package net.alternateadventure.brickforgery.guis;

import net.alternateadventure.brickforgery.containers.ContainerImprovedMillstone;
import net.alternateadventure.brickforgery.containers.ContainerSlicer;
import net.alternateadventure.brickforgery.tileentities.TileEntityImprovedMillstone;
import net.alternateadventure.brickforgery.tileentities.TileEntitySlicer;
import net.minecraft.client.gui.screen.container.ContainerBase;
import net.minecraft.entity.player.PlayerInventory;
import org.lwjgl.opengl.GL11;

public class GUIImprovedMillstone extends ContainerBase {
    private TileEntityImprovedMillstone improvedMillstone;

    public GUIImprovedMillstone(PlayerInventory arg, TileEntityImprovedMillstone arg2) {
        super(new ContainerImprovedMillstone(arg, arg2));
        this.improvedMillstone = arg2;
    }

    protected void renderForeground() {
        this.textManager.drawText("Improved", 4, 6, 4210752);
        this.textManager.drawText("Millstone", 4, 18, 4210752);
        this.textManager.drawText("Inventory", 4, this.containerHeight - 96 + 2, 4210752);
    }

    protected void renderContainerBackground(float f) {
        int var2 = this.minecraft.textureManager.getTextureId("/assets/brickforgery/stationapi/gui/improved_millstone.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.textureManager.bindTexture(var2);
        int var3 = (this.width - this.containerWidth) / 2;
        int var4 = (this.height - this.containerHeight) / 2;
        this.blit(var3, var4, 0, 0, this.containerWidth, this.containerHeight);
        int var5;
        var5 = this.improvedMillstone.getMillingTimeDelta(24);
        for (int index = 0; index < 3; index++) {
            this.blit(var3 + 79, var4 + 8 + 26 * index, 176, 14, var5 + 1, 16);
        }
    }
}
