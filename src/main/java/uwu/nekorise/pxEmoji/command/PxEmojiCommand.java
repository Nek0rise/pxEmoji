package uwu.nekorise.pxEmoji.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import uwu.nekorise.pxEmoji.config.LangConfigStorage;
import uwu.nekorise.pxEmoji.util.EmojiManager;
import uwu.nekorise.pxEmoji.util.HEX;

public class PxEmojiCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!sender.hasPermission("pxemoji.reload")) {
            return false;
        }
        if (args.length < 1 || !args[0].equalsIgnoreCase("reload")) {
            sender.sendMessage(HEX.applyColor(LangConfigStorage.reloadUsage));
            return false;
        }
        EmojiManager.buildEmoji();
        sender.sendMessage(HEX.applyColor(LangConfigStorage.reloadCompleted));
        return false;
    }
}
