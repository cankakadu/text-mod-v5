package de.texturecustomizer;

import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/** Small persistent settings store; expanded as features are implemented. */
public final class TextureCustomizerConfig {
    private static final Path FILE = FabricLoader.getInstance().getConfigDir().resolve("texturecustomizer.properties");
    private static final Properties VALUES = new Properties();

    private TextureCustomizerConfig() {}

    public static synchronized void load() {
        if (!Files.exists(FILE)) {
            save();
            return;
        }
        try (InputStream input = Files.newInputStream(FILE)) {
            VALUES.load(input);
        } catch (IOException exception) {
            System.err.println("[TextureCustomizer] Could not load config: " + exception.getMessage());
        }
    }

    public static synchronized String get(String key, String fallback) {
        return VALUES.getProperty(key, fallback);
    }

    public static synchronized void set(String key, String value) {
        VALUES.setProperty(key, value);
        save();
    }

    public static synchronized void save() {
        try {
            Files.createDirectories(FILE.getParent());
            try (OutputStream output = Files.newOutputStream(FILE)) {
                VALUES.store(output, "TextureCustomizer settings");
            }
        } catch (IOException exception) {
            System.err.println("[TextureCustomizer] Could not save config: " + exception.getMessage());
        }
    }
}
