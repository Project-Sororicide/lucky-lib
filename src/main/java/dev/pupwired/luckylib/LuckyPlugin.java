package dev.pupwired.luckylib;

import dev.pupwired.luckylib.events.ItemDropEvent;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class LuckyPlugin extends JavaPlugin {
    public static LuckyPlugin instance;

    public LuckyPlugin() {
        instance = this;
    }

    @Override
    public void onLoad() {
        getLogger().info("LuckyLib Loaded");
        getLogger().info("Te amo, minha corujinha <3");
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();

        var useItemDropEvent = isMechanicEnabled("disable-player-drops");
        registerEvent(new ItemDropEvent(this), useItemDropEvent);
    }

    public static LuckyPlugin getInstance() {
        return instance;
    }

    private void registerEvent(Listener listener) {
        getServer().getPluginManager().registerEvents(listener, this);
    }

    private void registerEvent(Listener listener, boolean condition) {
        if (condition) {
            getServer().getPluginManager().registerEvents(listener, this);
        }
    }

    public boolean isMechanicEnabled(String mechanic) {
        return getConfig().getBoolean("mechanics." + mechanic + ".enabled", false);
    }
}
