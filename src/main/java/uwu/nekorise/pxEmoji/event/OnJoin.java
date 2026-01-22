package uwu.nekorise.pxEmoji.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import uwu.nekorise.pxEmoji.config.MainConfigStorage;
import uwu.nekorise.pxEmoji.util.EmojiFiller;

public class OnJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (!MainConfigStorage.enableEmojis) {
            return;
        }
        Player player = event.getPlayer();
        EmojiFiller.addEmojisToTab(player);
    }
}
