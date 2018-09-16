package plugin.stefthedev.classicpvp.managers.items;

import plugin.stefthedev.classicpvp.Main;
import plugin.stefthedev.classicpvp.managers.Manager;
import plugin.stefthedev.classicpvp.utilities.Config;

import java.util.Arrays;

public class ConfigManager extends Manager<Config> {

    public ConfigManager(Main plugin) {
        super(plugin);
    }

    @Override
    public void serialise() {
        addConfigs("messages", "kits", "locations");
        getList().forEach(Config::setup);
    }

    private void addConfigs(String... strings) {
        Arrays.stream(strings).forEach(s -> getList().add(new Config(getPlugin(), s)));
    }

    @Override
    public void deserialise() {

    }
}
