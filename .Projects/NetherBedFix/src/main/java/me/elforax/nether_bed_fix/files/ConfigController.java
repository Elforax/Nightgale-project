package me.elforax.nether_bed_fix.files;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Config file controller Class\n
 * Creates/Loads/Saves the Config file.\n
 * Stores Config variables in memory after loading
 */
public class ConfigController {

    private static Plugin plugin;

    private static File file;
    private static FileConfiguration confFile;
    private static final File pathName = Bukkit.getServer().getPluginManager().getPlugin("NetherBedFix").getDataFolder();
    private static final String fileName = "Config.yml";

    //Config file content variables
    public static Boolean prevent_place = false;
    public static List<String> worlds = new ArrayList<>();
    public static List<String> bedTypes = new ArrayList<>();
    public static Boolean debug = false;

    /**
     * Initialization routine\n
     * Always needs to be called first
     * @param main Reference to the main plugin class generally done with "this" when called
     */
    public static void setup(Plugin main) {
        file = new File(pathName, fileName);
        plugin = main;

        if(!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){
                plugin.getLogger().log(Level.SEVERE ,"File " + fileName + " could not be created", e);
            }
        }

        confFile = YamlConfiguration.loadConfiguration(file);

        List<String> defaultWorlds = new ArrayList<>();
        defaultWorlds.add("world_nether");
        defaultWorlds.add("world_end");

        List<String> defaultBedTypes = defBedTypes();

        confFile.options().header("Nether Bed Fix");
        confFile.addDefault("prevent_place", true);

        confFile.addDefault("worlds", defaultWorlds);
        confFile.addDefault("bedtypes", defaultBedTypes);
        confFile.addDefault("debug", false);
        confFile.options().copyDefaults(true);
        save();
    }

    /**
     * Loads content from the configured config file
     */
    public static void load(){
        if(confFile == null){
            plugin.getLogger().log(Level.WARNING ,"Use Setup before Loading the config file content");
            return;
        }

        plugin.getLogger().info(ChatColor.GOLD + "Loaded " + fileName);

        prevent_place = confFile.getBoolean("prevent_place");
        worlds = confFile.getStringList("worlds");
        bedTypes = confFile.getStringList("bedtypes");
        debug = confFile.getBoolean("debug");
    }

    /**
     * Saving changes made to the Config file
     */
    public static void save(){
        try {
            confFile.save(file);
        }catch (IOException e){
            plugin.getLogger().log(Level.SEVERE ,"File Could not be saved", e);
        }
    }

    /**
     * Reloads the config file
     */
    public static void reload(){
        confFile = YamlConfiguration.loadConfiguration(file);
        load();
        plugin.getLogger().info(ChatColor.GOLD + "Reloaded file: " + fileName);
    }

    /**
     * returns the config file object
     * @return config file of type FileConfiguration
     */
    public static FileConfiguration getConfFile(){
        return confFile;
    }

    /**
     * gets a List of default Bed Types
     * @return list of bed types of type List String
     */
    public static List<String> defBedTypes(){
        List<String> defaultTypes = new ArrayList<>();

        defaultTypes.add("BLACK_BED");
        defaultTypes.add("BLUE_BED");
        defaultTypes.add("BROWN_BED");
        defaultTypes.add("CYAN_BED");
        defaultTypes.add("GRAY_BED");
        defaultTypes.add("GREEN_BED");
        defaultTypes.add("LIME_BED");
        defaultTypes.add("MAGENTA_BED");
        defaultTypes.add("ORANGE_BED");
        defaultTypes.add("PINK_BED");
        defaultTypes.add("PURPLE_BED");
        defaultTypes.add("RED_BED");
        defaultTypes.add("WHITE_BED");
        defaultTypes.add("YELLOW_BED");
        defaultTypes.add("LIGHT_BLUE_BED");
        defaultTypes.add("LIGHT_GRAY_BED");

        return defaultTypes;
    }
}
