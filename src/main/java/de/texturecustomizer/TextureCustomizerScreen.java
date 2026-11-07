package de.texturecustomizer;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

import java.util.List;

/** First functional UI shell. Feature panels are added in later milestones. */
public final class TextureCustomizerScreen extends Screen {
    private static final int PANEL = 0xE9161B25;
    private static final int TILE = 0xFF202A38;
    private static final int ACCENT = 0xFF8B6CFF;
    private static final List<String> CATEGORIES = List.of(
            "PvP & Kampf", "Waffen & Tools", "Rüstung", "Welt & Umgebung", "Inventar & HUD", "Effekte"
    );
    private String selectedCategory = CATEGORIES.get(0);

    public TextureCustomizerScreen() {
        super(Text.translatable("screen.texturecustomizer.title"));
    }

    @Override
    protected void init() {
        int left = Math.max(12, (width - 760) / 2);
        int top = Math.max(12, (height - 440) / 2);
        int navY = top + 76;
        int navWidth = 112;
        for (int i = 0; i < CATEGORIES.size(); i++) {
            String category = CATEGORIES.get(i);
            int x = left + 18 + i * (navWidth + 7);
            addDrawableChild(ButtonWidget.builder(Text.literal(category), button -> selectedCategory = category)
                    .dimensions(x, navY, navWidth, 22).build());
        }
        addDrawableChild(ButtonWidget.builder(Text.literal("Schließen"), button -> close())
                .dimensions(width - 112, height - 38, 96, 24).build());
        addDrawableChild(ButtonWidget.builder(Text.literal("Zurücksetzen"), button -> {
            selectedCategory = CATEGORIES.get(0);
            TextureCustomizerConfig.set("lastCategory", selectedCategory);
        }).dimensions(left + 18, height - 38, 110, 24).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        int panelWidth = Math.min(760, width - 24);
        int panelHeight = Math.min(440, height - 24);
        int left = (width - panelWidth) / 2;
        int top = (height - panelHeight) / 2;

        context.fill(left, top, left + panelWidth, top + panelHeight, PANEL);
        context.fill(left, top, left + panelWidth, top + 3, ACCENT);
        context.drawText(textRenderer, "TEXTURECUSTOMIZER", left + 18, top + 17, 0xFFFFFFFF, false);
        context.drawText(textRenderer, "Dein persönlicher Texture-Workspace", left + 18, top + 34, 0xFFB8C1D1, false);
        context.drawText(textRenderer, "BIBLIOTHEK   /   " + selectedCategory.toUpperCase(), left + 18, top + 64, ACCENT, false);

        int gridTop = top + 112;
        int gridLeft = left + 18;
        int gap = 10;
        int columns = 3;
        int tileWidth = (panelWidth - 36 - gap * (columns - 1)) / columns;
        int tileHeight = Math.max(68, Math.min(92, (panelHeight - 174) / 2));
        String[] labels = {"Sword", "Totem of Undying", "End Crystal", "Crosshair", "Sky", "Hotbar"};
        for (int i = 0; i < labels.length; i++) {
            int col = i % columns;
            int row = i / columns;
            int x = gridLeft + col * (tileWidth + gap);
            int y = gridTop + row * (tileHeight + gap);
            context.fill(x, y, x + tileWidth, y + tileHeight, TILE);
            context.fill(x, y, x + 3, y + tileHeight, 0xFF46556B);
            context.drawText(textRenderer, labels[i], x + 12, y + 12, 0xFFFFFFFF, false);
            context.drawText(textRenderer, "Noch nicht verbunden", x + 12, y + 31, 0xFF9AA7B8, false);
        }
        context.drawText(textRenderer, "Grundgerüst – weitere Module folgen schrittweise.", left + 18,
                top + panelHeight - 57, 0xFFB8C1D1, false);
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
