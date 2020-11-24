package me.elforax.weathery;

import me.elforax.weathery.files.FileManager;
import org.bukkit.ChatColor;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class Weathery extends JavaPlugin implements Listener {

    private static Plugin instance;

    private static FileManager playerVariables;
    private static FileConfiguration playerData;

    private static Map<String, Object> playerDataMap;

    @Override
    public void onEnable() {
        instance = this;
        // vv Plugin startup logic vv

        getLogger().info(format("&a" + instance.getName() + " Enabled"));

        FileManager config = new FileManager(instance, "config.yml");
        FileConfiguration configData = config.getFileData();

        playerVariables = new FileManager(instance, "playerdata.yml");
        playerData = playerVariables.getFileData();

        if(playerData != null) {
            playerDataMap = playerData.getValues(true);
        }else{
            playerDataMap = new HashMap<String, Object>();
            getLogger().info(format("&5 no Map found"));
        }

        for(String key : playerDataMap.keySet()){
            getLogger().info(format("&c" + key));
        }

        getServer().getPluginManager().registerEvents(this,this);

    }

    @Override
    public void onDisable(){

        Map<String, Object> storageDataMap = new HashMap<String, Object>();

        for(String key : playerDataMap.keySet()){
            String[] keySections = key.split("\\.");
            if(keySections.length >= 2) {
                storageDataMap.put(keySections[1], true);
            }
        }
        getLogger().info(format("&c" + storageDataMap.keySet()));

        playerData.createSection("Players", storageDataMap);
        playerVariables.save();
        // ^^ Plugin shutdown logic ^^
        instance = null;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        String playerUUID = player.getUniqueId().toString();

        if(!playerDataMap.containsKey(playerUUID)) {
            playerDataMap.put("Player." + playerUUID, true);
        }
    }

    public String format(@NotNull String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}

