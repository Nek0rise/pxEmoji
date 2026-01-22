package uwu.nekorise.pxEmoji.config;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import uwu.nekorise.pxEmoji.PxEmoji;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager {
    private static final String path = "./plugins/pxEmoji/";

    private static final String[] languageFiles = new String[] { "en.yml","ru.yml" };

    public static FileConfiguration getConfig(String cfgName) throws IOException, InvalidConfigurationException {
        YamlConfiguration yamlConfiguration = new YamlConfiguration();
        yamlConfiguration.options().parseComments(true);
        yamlConfiguration.load(path + cfgName);
        return yamlConfiguration;
    }

    private static void createConfigs() {
        File defaultConfig = new File(path, "config.yml");
        if (!defaultConfig.exists())
            PxEmoji.getInstance().saveResource("config.yml", false);
        List<String> langConfigFiles = new ArrayList<>(Arrays.asList(languageFiles));
        for (String langConfigName : langConfigFiles) {
            File langConfig = new File(path, "langs/" + langConfigName);
            if (!langConfig.exists())
                PxEmoji.getInstance().saveResource("langs/" + langConfigName, false);
        }
    }

    public static void reloadConfigs() {
        createConfigs();
        MainConfigStorage.loadConfig();
        LangConfigStorage.loadConfig();
    }
}
