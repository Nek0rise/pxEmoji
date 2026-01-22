package uwu.nekorise.pxEmoji.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import uwu.nekorise.pxEmoji.config.MainConfigStorage;
import uwu.nekorise.pxEmoji.util.HEX;

import static org.bukkit.event.EventPriority.*;

public class OnSignChange implements Listener {
    @EventHandler(priority = HIGH)
    public void onSignChange(SignChangeEvent event) {
        String[] lines = event.getLines();
        for (int i = 0; i < lines.length; i++) {
            if (lines[i] != null)
                for (String emoji : MainConfigStorage.emojiList) {
                    lines[i] = lines[i].replace(emoji, HEX.applyColor("&f" + emoji + "&r"));
                    event.setLine(i, lines[i]);
                }
        }
    }
}
