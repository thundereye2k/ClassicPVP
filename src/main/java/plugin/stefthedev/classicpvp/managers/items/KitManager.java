package plugin.stefthedev.classicpvp.managers.items;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import plugin.stefthedev.classicpvp.Main;
import plugin.stefthedev.classicpvp.managers.Manager;
import plugin.stefthedev.classicpvp.utilities.Kit;
import plugin.stefthedev.classicpvp.utilities.Item;

import java.util.ArrayList;
import java.util.List;

public class KitManager extends Manager<Kit> {

    public KitManager(Main plugin) {
        super(plugin);
    }

    @Override
    public void serialise() {
        ConfigurationSection configSection = config().getConfigurationSection("");
        if(configSection == null) return;
        configSection.getKeys(false).forEach(s -> getList().add(
                new Kit(s, config().getString(s + ".permission"), new Item(s,
                        config().getString(s + ".icon.name"),
                        Material.valueOf(config().getString(s + ".icon.material")),
                        config().getInt(s + ".icon.subID"),
                        config().getInt(s + ".icon.amount"),
                        config().getInt(s + ".icon.slot"),
                        null,
                        config().getStringList(s + ".icon.lore")
                ), items(s)
            )
        ));
    }

    @Override
    public void deserialise() {

    }

    private List<Item> items(String key) {
        List<Item> list = new ArrayList<>();
        ConfigurationSection configSection = config().getConfigurationSection(key + ".items");
        if(configSection == null) return null;
        configSection.getKeys(false).forEach(s ->
                list.add(new Item(
                        key, config().getString(key + ".items." + s + ".name"),
                        Material.valueOf(config().getString(key + ".items." + s + ".material")),
                        config().getInt(key + ".items." + s + ".subID"),
                        config().getInt(key + ".items." + s + ".amount"),
                        config().getInt(key + ".items." + s + ".slot"),
                        config().getStringList(key + ".items." + s + ".enchantments"),
                        config().getStringList(key + ".items." + s + ".lore")
        )));
        return list;
    }

    private FileConfiguration config() {
        return getPlugin().getConfigManager().getElement("kits").getConfig();
    }
}
