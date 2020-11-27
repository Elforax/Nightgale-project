package me.elforax.infernalmadness.files;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class FileManager {
    private final Plugin plugin;

    private final File file;
    private FileConfiguration confFile;

    /**
     * File manager constructor\n
     * used to create pre written file and safe them in the plugins/{pluginName} folder\n
     * for easy access to plugin parameters
     * @param main  Reference to the main class of the plugin
     * @param filename  File name that needs to be stored in the folder
     */
    public FileManager(Plugin main, String filename){
        this.plugin = main;

        this.file = new File(this.plugin.getDataFolder(), filename);

        // creates the dir if it does not exists
        if(!this.plugin.getDataFolder().exists()){
            this.plugin.getDataFolder().mkdirs();
        }

        // creates the file if it does not exists
        if(!this.file.exists()){
            new FileCopy().copy(this.plugin.getResource(filename), this.file);
        }

        this.confFile = YamlConfiguration.loadConfiguration(this.file);

    }

    /**
     * Saving changes made to the Config file
     */
    public void save(){
        try {
            this.confFile.save(this.file);
        }catch (IOException e){
            this.plugin.getLogger().log(Level.SEVERE ,"File Could not be saved", e);
        }
    }

    /**
     * Reloads the config file
     */
    public void reload(){
        this.confFile = YamlConfiguration.loadConfiguration(this.file);
    }

    /**
     * returns the file object in YML format\n
     * Contains all the variables in the attached file
     * @return object of type FileConfiguration
     */
    public FileConfiguration getFileData(){
        return this.confFile;
    }
}
