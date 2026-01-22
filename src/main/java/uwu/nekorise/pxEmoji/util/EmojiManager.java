package uwu.nekorise.pxEmoji.util;

import uwu.nekorise.pxEmoji.config.ConfigManager;

public class EmojiManager {
    public static void buildEmoji() {
        ConfigManager.reloadConfigs();
        EmojiFiller.generateUUIDs();
    }
}
