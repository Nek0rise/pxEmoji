package uwu.nekorise.pxEmoji.util;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.PlayerInfoData;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import com.comphenix.protocol.wrappers.WrappedGameProfile;
import java.util.Collections;
import java.util.EnumSet;
import java.util.UUID;
import org.bukkit.entity.Player;

public final class EmojiPacketSender {

    private static ProtocolManager manager;

    private EmojiPacketSender() {}

    private static ProtocolManager getManager() {
        if (manager == null) {
            manager = ProtocolLibrary.getProtocolManager();
            if (manager == null) {
                throw new IllegalStateException("Install ProtocolLib :p");
            }
        }
        return manager;
    }

    public static void sendAdd(Player player, UUID uuid, String name) {
        ProtocolManager mgr = getManager();
        PacketContainer packet = mgr.createPacket(PacketType.Play.Server.PLAYER_INFO);
        packet.getPlayerInfoActions().write(0, EnumSet.of(EnumWrappers.PlayerInfoAction.ADD_PLAYER));
        packet.getPlayerInfoDataLists().write(1, Collections.singletonList(new PlayerInfoData(new WrappedGameProfile(uuid, name), 10, EnumWrappers.NativeGameMode.SURVIVAL, WrappedChatComponent.fromText(name))));
        mgr.sendServerPacket(player, packet);
    }
}
