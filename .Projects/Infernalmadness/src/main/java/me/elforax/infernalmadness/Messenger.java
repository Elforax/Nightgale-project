package me.elforax.infernalmadness;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class Messenger {
    private final Plugin plugin;
    public Messenger(Plugin main){
        this.plugin = main;
    }

    public void info(String msg, Boolean formatted){
        if(!msg.isEmpty()){
            if(formatted){
                plugin.getLogger().info(format(msg));
            }else{
                plugin.getLogger().info(ChatColor.AQUA + msg);
            }
        }else{
            plugin.getLogger().info(ChatColor.RED + "Expected a String got Empty String!");
        }

    }

    public void info(Player player, String msg, Boolean formatted){
        if(!msg.isEmpty()){
            if(formatted){
                player.sendMessage(format(msg));
            }else{
                player.sendMessage(ChatColor.AQUA + msg);
            }
        }else{
            plugin.getLogger().info(ChatColor.RED + "Expected a String for a player got Empty String!");
        }
    }

    private String format(@NotNull String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
