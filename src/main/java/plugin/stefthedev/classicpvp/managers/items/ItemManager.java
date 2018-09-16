package plugin.stefthedev.classicpvp.managers.items;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import plugin.stefthedev.classicpvp.Main;
import plugin.stefthedev.classicpvp.managers.Manager;
import plugin.stefthedev.classicpvp.utilities.Item;

public class ItemManager extends Manager<Item> {

    public ItemManager(Main plugin) {
        super(plugin);
    }

    public void serialise() {
        FileConfiguration config = getPlugin().getConfig();
        ConfigurationSection configSection = config.getConfigurationSection("Items");
        configSection.getKeys(false).forEach(s -> getList().add(new Item(
                s, config.getString("Items." + s + ".name"),
                Material.getMaterial(config.getString("Items." + s + ".material")),
                config.getInt("Items." + s + ".subID"),
                config.getInt("Items." + s + ".amount"),
                config.getInt("Items." + s + ".slot"),
                null,
                config.getStringList("Items." + s + ".lore")
        )));
    }

    @Override
    public void deserialise() {

    }

    public Item getSoup() {
        return getElement("soup");
    }

    public Item getKits() {
        return getElement("kits");
    }

    public Item getLeave() {
        return getElement("leave");
    }

    public void fillSoup(Player player) {
        Inventory inventory = player.getInventory();
        for (int i = 0; i < inventory.getSize(); i++) {
            if (inventory.getItem(i) == null || inventory.getItem(i).getType() == Material.AIR) {
                inventory.setItem(i, getElement("soup").build());
            }
        }
    }
}
