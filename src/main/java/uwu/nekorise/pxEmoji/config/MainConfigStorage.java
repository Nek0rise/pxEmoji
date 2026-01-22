package uwu.nekorise.pxEmoji.config;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

public class MainConfigStorage {
    public static String language;
    public static List<String> emojiList;
    public static boolean enableEmojis = true;

    public static void loadConfig() {
        try {
            FileConfiguration config = ConfigManager.getConfig("config.yml");

            emojiList = new ArrayList<>();
            emojiList = config.getStringList("emoji-list");
            enableEmojis = config.getBoolean("enable-emojis");
            language = config.getString("language");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
