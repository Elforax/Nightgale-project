package me.elforax.nether_bed_fix;

import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.*;

import java.util.logging.Logger;

public class Messenger {

    private final Logger msgController;

    public Messenger(@NotNull Plugin main){
        //Init Function
        this.msgController = main.getLogger();
    }

    public void infoConsole(String text, ChatColor color){
        if(color == null) {
            msgController.info(text);
        }else{
            msgController.info(color + "" + text);
        }
    }


}
