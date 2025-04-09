package net.alternateadventure.brickforgery.guis;

import net.alternateadventure.brickforgery.containers.AlloySmelterScreenHandler;
import net.alternateadventure.brickforgery.tileentities.TileEntityAlloySmelter;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import org.lwjgl.opengl.GL11;

@Environment(EnvType.CLIENT)
public class AlloySmelterScreen extends HandledScreen {
    private final TileEntityAlloySmelter alloySmelter;

    public AlloySmelterScreen(PlayerInventory arg, TileEntityAlloySmelter arg2) {
        super(new AlloySmelterScreenHandler(arg, arg2));
        this.alloySmelter = arg2;
    }

    @Override
    protected void drawForeground() {
        this.textRenderer.draw("Alloy Smelter", 60, 6, 4210752);
        this.textRenderer.draw("Inventory", 8, this.backgroundHeight - 96 + 2, 4210752);
    }

    @Override
    protected void drawBackground(float f) {
        int var2 = this.minecraft.textureManager.getTextureId("/assets/brickforgery/stationapi/gui/alloysmelter.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.textureManager.bindTexture(var2);
        int var3 = (this.width - this.backgroundWidth) / 2;
        int var4 = (this.height - this.backgroundHeight) / 2;
        this.drawTexture(var3, var4, 0, 0, this.backgroundWidth, this.backgroundHeight);
        int var5;
        if (this.alloySmelter.isBurning()) {
            var5 = this.alloySmelter.getFuelTimeDelta(12);
            this.drawTexture(var3 + 38, var4 + 66 - var5, 176, 12 - var5, 14, var5 + 2);
        }
        var5 = this.alloySmelter.getCookTimeDelta(24);
        this.drawTexture(var3 + 79, var4 + 34, 176, 14, var5 + 1, 16);
    }
}
