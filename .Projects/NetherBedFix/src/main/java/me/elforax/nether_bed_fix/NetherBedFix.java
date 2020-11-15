package me.elforax.nether_bed_fix;

import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class NetherBedFix extends JavaPlugin {

    private static Plugin instance;

    @Override
    public void onEnable() {
        instance = this;
        Messenger messenger = new Messenger(instance);
        messenger.infoConsole("NetherBedFix Enabled", ChatColor.GREEN);

    }

    @Override
    public void onDisable() {

        // instance deletion always last!
        instance = null; //<! Removes the instance of the main plugin from memory
    }
}
