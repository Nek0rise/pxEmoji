package uwu.nekorise.pxEmoji.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public final class EmojiRegistry {
    private static final List<UUID> FAKE_UUIDS = new ArrayList<>();

    public static List<UUID> getFakeUUIDs() {
        return Collections.unmodifiableList(FAKE_UUIDS);
    }

    public static void regenerate(int count) {
        FAKE_UUIDS.clear();
        for (int i = 0; i < count; i++) {
            FAKE_UUIDS.add(UUID.randomUUID());
        }
    }
}
