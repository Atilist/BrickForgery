package net.alternateadventure.brickforgery.guis;

import net.alternateadventure.brickforgery.blocks.entity.BrickForgeBlockEntity;
import net.alternateadventure.brickforgery.containers.BrickForgeScreenHandler;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import org.lwjgl.opengl.GL11;

public class BrickForgeScreen extends HandledScreen {
    private final BrickForgeBlockEntity brickForgeBlockEntity;

    public BrickForgeScreen(PlayerInventory arg, BrickForgeBlockEntity brickForgeBlockEntity) {
        super(new BrickForgeScreenHandler(arg, brickForgeBlockEntity));
        this.brickForgeBlockEntity = brickForgeBlockEntity;
    }

    @Override
    protected void drawForeground() {
        this.textRenderer.draw("Brick Forge", 60, 6, 4210752);
        this.textRenderer.draw("Inventory", 8, this.backgroundHeight - 96 + 2, 4210752);
    }

    @Override
    protected void drawBackground(float f) {
        int var2 = this.minecraft.textureManager.getTextureId("/assets/brickforgery/stationapi/gui/brick_forge.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.textureManager.bindTexture(var2);
        int var3 = (this.width - this.backgroundWidth) / 2;
        int var4 = (this.height - this.backgroundHeight) / 2;
        this.drawTexture(var3, var4, 0, 0, this.backgroundWidth, this.backgroundHeight);
        int var5 = this.brickForgeBlockEntity.getForgeTimeDelta(24);
        this.drawTexture(var3 + 79, var4 + 34, 176, 14, var5 + 1, 16);
    }
}
