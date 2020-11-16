package me.elforax.nether_bed_fix.commands;

import me.elforax.nether_bed_fix.files.ConfigController;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GetWorlds implements CommandExecutor {
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
