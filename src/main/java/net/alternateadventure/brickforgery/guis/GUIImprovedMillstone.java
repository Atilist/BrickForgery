package net.alternateadventure.brickforgery.guis;

import net.alternateadventure.brickforgery.containers.ImprovedMillstoneScreenHandler;
import net.alternateadventure.brickforgery.tileentities.TileEntityImprovedMillstone;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import org.lwjgl.opengl.GL11;

public class GUIImprovedMillstone extends HandledScreen {
    private final TileEntityImprovedMillstone improvedMillstone;

    public GUIImprovedMillstone(PlayerInventory arg, TileEntityImprovedMillstone arg2) {
        super(new ImprovedMillstoneScreenHandler(arg, arg2));
        this.improvedMillstone = arg2;
    }

    @Override
    protected void drawForeground() {
        this.textRenderer.draw("Improved", 4, 6, 4210752);
        this.textRenderer.draw("Millstone", 4, 18, 4210752);
        this.textRenderer.draw("Inventory", 4, this.backgroundHeight - 96 + 2, 4210752);
    }

    @Override
    protected void drawBackground(float f) {
        int var2 = this.minecraft.textureManager.getTextureId("/assets/brickforgery/stationapi/gui/improved_millstone.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.textureManager.bindTexture(var2);
        int var3 = (this.width - this.backgroundWidth) / 2;
        int var4 = (this.height - this.backgroundHeight) / 2;
        this.drawTexture(var3, var4, 0, 0, this.backgroundWidth, this.backgroundHeight);
        int var5;
        var5 = this.improvedMillstone.getMillingTimeDelta(24);
        for (int index = 0; index < 3; index++) {
            this.drawTexture(var3 + 79, var4 + 8 + 26 * index, 176, 14, var5 + 1, 16);
        }
    }
}
