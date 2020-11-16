package me.elforax.nether_bed_fix;

import me.elforax.nether_bed_fix.commands.GetWorlds;
import me.elforax.nether_bed_fix.commands.Reload;
import me.elforax.nether_bed_fix.files.ConfigController;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main Plugin Class
 */
public final class NetherBedFix extends JavaPlugin {

    private static Plugin instance;

    @Override
    public void onEnable() {
        instance = this;
        Messenger messenger = new Messenger(instance);
        messenger.infoConsole("NetherBedFix Loaded", ChatColor.GREEN);

        ConfigController.setup(instance);
        ConfigController.load();

        this.getCommand( "netherfixreload").setExecutor(new Reload());
        this.getCommand( "netherfixworlds").setExecutor(new GetWorlds());

        getServer().getPluginManager().registerEvents(new Events(), this);
    }

    @Override
    public void onDisable() {
        // instance deletion always last!
        instance = null; //<! Removes the instance of the main plugin from memory
    }
}
