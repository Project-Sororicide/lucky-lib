package dev.pupwired.luckylib.message;

import dev.pupwired.luckylib.LuckyPlugin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.command.CommandSender;

public interface LuckyMessage {

    MiniMessage MM = MiniMessage.miniMessage();

    String getRaw();

    default String getRaw(Object... strings) {
        int matches = StringUtils.countMatches(getRaw(), "%s");

        if (matches != strings.length) {
            LuckyPlugin.getInstance().getLogger().severe("Mismatch in messages, incorrect parameters supplied for " + getRaw() +
                    ". Please inform plugin author.");
        }
        return String.format(getRaw(), strings);
    }

    default Component getComponent() {
        return MM.deserialize(getRaw());
    }

    default Component getComponent(Object... strings) {
        return MM.deserialize(getRaw(strings));
    }

    default void sendMessage(CommandSender sender) {
        sender.sendMessage(getComponent());
    }

    default void sendMessage(CommandSender sender, Object... strings) {
        sender.sendMessage(getComponent(strings));
    }

}
