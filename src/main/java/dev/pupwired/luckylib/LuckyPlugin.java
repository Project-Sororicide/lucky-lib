package dev.pupwired.luckylib;

import dev.pupwired.luckylib.events.ItemDropEvent;
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
        getServer().getPluginManager().registerEvents(new ItemDropEvent(), this);
    }

    public static LuckyPlugin getInstance() {
        return instance;
    }
}
