package dev.pupwired.luckylib;

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

    public static LuckyPlugin getInstance() {
        return instance;
    }
}
