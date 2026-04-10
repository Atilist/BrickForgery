package net.alternateadventure.brickforgery.util;

public enum TierEnum {
    SUGAR_CANE("§a", "Sugar Cane"),
    CACTUS("§2", "Cactus"),
    FLINT("§8", "Flint"),
    WOOD("§4", "Wood"),
    STONE("§7", "Stone"),
    PRIMITIVE("§6", "Primitive"),
    BRICK("§c", "Brick");

    private final String colourCode;
    private final String name;

    TierEnum(final String colourCode, final String name) {
        this.colourCode = colourCode;
        this.name = name;
    }

    public String getColourCode() {
        return colourCode;
    }

    public String getName() {
        return name;
    }
}
