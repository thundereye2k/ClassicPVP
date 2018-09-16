package plugin.stefthedev.classicpvp.utilities;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class Config {

    private final JavaPlugin javaPlugin;
    private final String name;
    private FileConfiguration config;
    private File configFile;

    public Config(JavaPlugin javaPlugin, String name) {
        this.javaPlugin = javaPlugin;
        this.name = name;
    }

    public void setup() {
        if (this.configFile == null) {
            this.configFile = new File(this.javaPlugin.getDataFolder(), this.name + ".yml");
        }
        if (!this.configFile.exists()) {
            this.configFile.getParentFile().mkdirs();
            this.javaPlugin.saveResource(this.name + ".yml", false);
        }
        reload();
        load();
        save();
    }

    public void reload() {
        this.config = YamlConfiguration.loadConfiguration(configFile);
    }

    public FileConfiguration getConfig() {
        return config;
    }

    private void load() {
        this.config.options().copyDefaults(true);
    }

    public void save() {
        try {
            this.config.save(configFile);
        }
        catch (IOException ex) {
            this.javaPlugin.getLogger().log(Level.SEVERE, "Could not save config to " + this.configFile, ex);
        }
    }

    public String getName() {
        return name;
    }
}
