package me.elforax.nether_bed_fix.commands;

import me.elforax.nether_bed_fix.files.ConfigController;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * getWorlds command executor Class\.
 * Gets the list of worlds that are listed in the configs
 */
public class GetWorlds implements CommandExecutor {

    /**
     * GetWorlds command executor
     * @param sender player/console who gave the command
     * @param command specific command
     * @param s command text
     * @param strings extra arguments added to the plugin
     * @return returns boolean if command succeeded
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(sender instanceof Player){
            Player player = (Player)sender;

            if(!player.hasPermission("netherfix.getworlds")){
                return false;
            }

            player.sendMessage(ChatColor.AQUA + " | Disabled worlds |");
            for(String world : ConfigController.worlds){
                player.sendMessage(ChatColor.AQUA + " - " + world);
            }
        }else {
            sender.sendMessage(ChatColor.AQUA + " | Disabled worlds |");
            for (String world : ConfigController.worlds) {
                sender.sendMessage(ChatColor.AQUA + " - " + world);
            }
        }
        return true;
    }
}
