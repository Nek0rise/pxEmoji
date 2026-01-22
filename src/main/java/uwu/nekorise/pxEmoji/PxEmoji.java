package uwu.nekorise.pxEmoji;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import uwu.nekorise.pxEmoji.command.PxEmojiCommand;
import uwu.nekorise.pxEmoji.command.PxEmojiTabCompleter;
import uwu.nekorise.pxEmoji.event.OnJoin;
import uwu.nekorise.pxEmoji.event.OnSignChange;
import uwu.nekorise.pxEmoji.util.EmojiManager;

public final class PxEmoji extends JavaPlugin {
    private static PxEmoji instance;

    @Override
    public void onEnable() {
        instance = this;

        registerCommands();
        registerTabCompleters();
        registerListeners();

        EmojiManager.buildEmoji();
    }

    private void registerCommands() {
        getCommand("pxemoji").setExecutor(new PxEmojiCommand());
    }

    private void registerTabCompleters() {
        getCommand("pxemoji").setTabCompleter(new PxEmojiTabCompleter());
    }

    private void registerListeners() {
        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(new OnJoin(), instance);
        pm.registerEvents(new OnSignChange(), instance);
    }

    public static PxEmoji getInstance() {
        return instance;
    }
}
