package me.elforax.infernalmadness;

import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;

public final class Infernalmadness extends JavaPlugin {
    private Plugin instance;
    private Messenger msg;
    
    @Override
    public void onEnable() {
        instance = this;
        msg = new Messenger(instance);
        // Plugin startup logic vv
        msg.info("1& " + this.getName() + " Enabled", true);


        MadnessController madness = new MadnessController(instance);
        getServer().getPluginManager().registerEvents(madness, instance);
        madness.scoreboardTest();


    }

    @Override
    public void onDisable() {
        msg.info("a&" + this.getName() + " Disabled", true);

        // Plugin shutdown logic ^^
        instance = null;
    }
}
