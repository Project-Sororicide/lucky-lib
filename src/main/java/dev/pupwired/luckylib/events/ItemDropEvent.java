package dev.pupwired.luckylib.events;

import dev.pupwired.luckylib.LuckyPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ItemDropEvent implements Listener {

    private final LuckyPlugin plugin;

    public ItemDropEvent(LuckyPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPlayerItemDrop(PlayerDropItemEvent event) {
        if (!plugin.isMechanicEnabled("disable-player-drops")) return;

        String permission = plugin.getConfig().getString(
                "mechanics.disable-player-drops.permission",
                "luckylib.allowdrops"
        );

        if (!event.getPlayer().hasPermission(permission)) {
            event.setCancelled(true);
        }
    }
}
