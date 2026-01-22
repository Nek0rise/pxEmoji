package uwu.nekorise.pxEmoji.config;

import org.bukkit.configuration.file.FileConfiguration;

public class LangConfigStorage {
    public static String reloadUsage;
    public static String reloadCompleted;

    public static void loadConfig() {
        try {
            FileConfiguration cfg = ConfigManager.getConfig("langs/" + MainConfigStorage.language + ".yml");

            reloadUsage = cfg.getString("reload.usage");
            reloadCompleted = cfg.getString("reload.completed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
