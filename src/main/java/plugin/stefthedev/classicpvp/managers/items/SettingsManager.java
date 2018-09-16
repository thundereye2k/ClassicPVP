package plugin.stefthedev.classicpvp.managers.items;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import plugin.stefthedev.classicpvp.Main;
import plugin.stefthedev.classicpvp.managers.Manager;
import plugin.stefthedev.classicpvp.utilities.Setting;

public class SettingsManager extends Manager<Setting> {

    public SettingsManager(Main plugin) {
        super(plugin);
    }

    public void serialise() {
        FileConfiguration config = getPlugin().getConfig();
        ConfigurationSection configSection = config.getConfigurationSection("Settings");
        if(configSection == null) return;
        configSection.getKeys(false).forEach(s -> getList().add(
                new Setting(s.toLowerCase(), config.getBoolean("Settings." + s))
        ));
    }

    public void deserialise() {
        getList().clear();
    }
}
