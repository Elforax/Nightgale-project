package me.elforax.infernalmadness;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Infernalmadness extends JavaPlugin {
    private Plugin instance;
    private Messenger msg;
    
    @Override
    public void onEnable() {
        instance = this;
        msg = new Messenger(instance);
        // Plugin startup logic vv
        msg.info("a&" + this.getName() + " Enabled", true);
    }

    @Override
    public void onDisable() {
        msg.info("a&" + this.getName() + " Disabled", true);

        // Plugin shutdown logic ^^
        instance = null;
    }
}
