package plugin.stefthedev.classicpvp.managers.items;

import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import plugin.stefthedev.classicpvp.Main;
import plugin.stefthedev.classicpvp.managers.Manager;
import plugin.stefthedev.classicpvp.utilities.Config;

import java.util.Random;

public class LocationManager extends Manager<Location> {

    private final Main plugin;
    private Config config;
    private Location location;

    public LocationManager(Main plugin) {
        super(plugin);
        this.plugin = plugin;
    }

    public void serialise() {
        this.config = plugin.getConfigManager().getElement("locations");
        location = (Location) config().get("Lobby");
        ConfigurationSection configSection = config().getConfigurationSection("Spawns");
        if(configSection == null) return;
        configSection.getKeys(false).forEach(s -> getList().add(
                (Location) config().get("Spawns." + s)
        ));
    }

    public void deserialise() {
        int i = 0;
        config().set("Lobby", location);
        if(getList().isEmpty()) return;
        for(Location location : getList()) {
            i++;
            config().set("Spawns." + i, location);
        }
        config.save();
    }

    public Location randomLocation() {
        if(getList().isEmpty()) return null;
        return getList().get(new Random().nextInt(getList().size()));
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    private FileConfiguration config() {
        return config.getConfig();
    }
}
