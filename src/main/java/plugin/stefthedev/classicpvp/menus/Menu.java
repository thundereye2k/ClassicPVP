package plugin.stefthedev.classicpvp.menus;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import plugin.stefthedev.classicpvp.Main;


public abstract class Menu implements InventoryHolder {

    private final Main plugin;
    private final int size;
    private final String name, key;
    private Inventory inventory;

    public Menu(Main plugin, String key) {
        this.plugin = plugin;
        this.size = plugin.getConfig().getInt("Menu." + key + ".size");
        this.name = plugin.getConfig().getString("Menu." + key + ".name");
        this.key = key;
        this.inventory = plugin.getServer().createInventory(this, size, name);
    }

    public void open(Player player) {
        addItems(player);
        player.openInventory(inventory);
    }

    public abstract void addItems(Player player);

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    protected Main getPlugin() {
        return plugin;
    }

    protected String getKey() {
        return key;
    }

    protected int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }
}
