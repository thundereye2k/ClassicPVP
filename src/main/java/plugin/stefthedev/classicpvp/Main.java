package plugin.stefthedev.classicpvp;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.stefthedev.classicpvp.commands.PvPCommand;
import plugin.stefthedev.classicpvp.listeners.BlockListener;
import plugin.stefthedev.classicpvp.listeners.EntityListener;
import plugin.stefthedev.classicpvp.listeners.InventoryListener;
import plugin.stefthedev.classicpvp.listeners.PlayerListener;
import plugin.stefthedev.classicpvp.managers.Manager;
import plugin.stefthedev.classicpvp.managers.items.*;
import plugin.stefthedev.classicpvp.menus.items.KitMenu;
import plugin.stefthedev.classicpvp.menus.items.PreviewMenu;
import plugin.stefthedev.classicpvp.utilities.Config;
import plugin.stefthedev.classicpvp.utilities.Message;

import java.util.Arrays;

public class Main extends JavaPlugin {

    private final KitManager kitManager = new KitManager(this);
    private final ConfigManager configManager = new ConfigManager(this);
    private final LocationManager locationManager = new LocationManager(this);
    private final ItemManager itemManager = new ItemManager(this);
    private final SettingsManager settingsManager = new SettingsManager(this);

    private KitMenu kitMenu;
    private PreviewMenu previewMenu;

    public void onEnable() {
        saveDefaultConfig();

        managers(true,
                configManager,
                itemManager,
                locationManager,
                kitManager,
                settingsManager
        );

        registerMessages();

        registerListeners(
                new BlockListener(this),
                new EntityListener(this),
                new InventoryListener(this),
                new PlayerListener(this)
        );

        kitMenu = new KitMenu(this);
        previewMenu = new PreviewMenu(this);

        getCommand("pvp").setExecutor(new PvPCommand(this));
    }

    public void onDisable() {
        managers(false,
                kitManager,
                locationManager,
                itemManager,
                settingsManager,
                configManager
        );
    }

    public void runAsync(Runnable runnable) {
        getServer().getScheduler().runTaskAsynchronously(this, runnable);
    }

    private void registerListeners(Listener... listeners) {
        PluginManager pluginManager = getServer().getPluginManager();
        Arrays.stream(listeners).forEach(listener -> pluginManager.registerEvents(listener, this));
    }

    private void managers(boolean register, Manager... managers) {
        if(register) {
            Arrays.stream(managers).forEach(Manager::serialise);
        } else {
            Arrays.stream(managers).forEach(Manager::deserialise);
        }
    }

    private void registerMessages() {
        Config config = configManager.getElement("messages");
        Message.setFile(config.getConfig());
        Arrays.asList(Message.values()).forEach(message ->
                config.getConfig().addDefault(message.getPath(), message.getDefault().replace("§", "&"))
        );

        config.getConfig().options().copyDefaults(true);
        config.save();
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public KitManager getKitManager() {
        return kitManager;
    }

    public LocationManager getLocationManager() {
        return locationManager;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public SettingsManager getSettingsManager() {
        return settingsManager;
    }

    public KitMenu getKitMenu() {
        return kitMenu;
    }

    public PreviewMenu getPreviewMenu() {
        return previewMenu;
    }
}
