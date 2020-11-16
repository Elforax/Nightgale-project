package me.elforax.nether_bed_fix;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.*;

import java.util.logging.Logger;

public class Messenger {

    private final Logger msgController;

    /**
     * Messenger constructor
     * @param main Reference to the main plugin class generally done with "this" when called
     */
    public Messenger(@NotNull Plugin main){
        //Init Function
        this.msgController = main.getLogger();
    }

    /**
     * Console text controller
     * @param text  Text that needs to be send to the console
     * @param color The color of the text. if null default will be used
     */
    public void infoConsole(String text, ChatColor color){
        if(text.equals("")) {
            msgController.info(ChatColor.RED + "String was Empty!");
            return;
        }
        if(color == null) {
            msgController.info(text);
        }else{
            msgController.info(color + "" + text);
        }
    }

    /**
     * Console text controller
     * @param player Player that needs to receive the message
     * @param text  Text that needs to be send to the given player
     * @param color The color of the text. if null default will be used
     */
    public void infoPlayerSimple(@NotNull Player player, String text, ChatColor color){
        if(text.equals("") || player == null) {
            msgController.info(ChatColor.RED + "String was Empty or no player given!");
            return;
        }
        if(color == null) {
            player.sendMessage(text);
        }else{
            player.sendMessage(color + "" + text);
        }
    }


}
