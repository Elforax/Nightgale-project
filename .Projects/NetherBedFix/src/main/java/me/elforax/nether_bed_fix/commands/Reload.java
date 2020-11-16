package me.elforax.nether_bed_fix.commands;

import me.elforax.nether_bed_fix.files.ConfigController;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class Reload implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(sender instanceof Player){
            Player player = (Player) sender;

            if(!player.hasPermission("netherfix.reload")){
                return false;
            }

            player.sendMessage(ChatColor.GREEN + "NetherBedFix files reloaded");
        }else{
            sender.sendMessage(ChatColor.GREEN + "NetherBedFix files reloaded");
        }
        ConfigController.reload();
        return true;
    }
}
