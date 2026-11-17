package dev.pupwired.luckylib.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ItemDropEvent implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPlayerItemDrop(PlayerDropItemEvent event) {
        if (!event.getPlayer().hasPermission("luckylib.allowdrops")) {
            event.setCancelled(true);
        }
    }
}
