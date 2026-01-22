package uwu.nekorise.pxEmoji.util;

import java.util.List;
import java.util.UUID;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import uwu.nekorise.pxEmoji.PxEmoji;
import uwu.nekorise.pxEmoji.config.MainConfigStorage;

public final class EmojiFiller {
    private EmojiFiller() {}
    public static void generateUUIDs() {
        EmojiRegistry.regenerate(MainConfigStorage.emojiList.size());
    }

    public static void addEmojisToTab(Player viewer) {
        List<UUID> uuids = EmojiRegistry.getFakeUUIDs();
        new BukkitRunnable() {
            int index = 0;
            @Override
            public void run() {
                if (index >= uuids.size()) {
                    cancel();
                    return;
                }
                EmojiPacketSender.sendAdd(viewer, uuids.get(index), MainConfigStorage.emojiList.get(index));
                index++;
            }
        }.runTaskTimer(PxEmoji.getInstance(), 0L, 1L);
    }
}
