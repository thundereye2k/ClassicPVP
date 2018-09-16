package plugin.stefthedev.classicpvp.managers;

import plugin.stefthedev.classicpvp.Main;
import plugin.stefthedev.classicpvp.utilities.Config;
import plugin.stefthedev.classicpvp.utilities.Item;
import plugin.stefthedev.classicpvp.utilities.Kit;
import plugin.stefthedev.classicpvp.utilities.Setting;

import java.util.ArrayList;
import java.util.List;

public abstract class Manager<T> {

    private final Main plugin;
    private List<T> list;

    public Manager(Main plugin) {
        this.plugin = plugin;
        this.list = new ArrayList<>();
    }

    public abstract void serialise();

    public void deserialise() {
        list.clear();
    }

    public T getElement(String key) {
        for(T t: list) {
            if((t instanceof Config) && ((Config) t).getName().equalsIgnoreCase(key)) {
                return t;
            }
            if((t instanceof Kit) && ((Kit) t).getKey().equalsIgnoreCase(key)) {
                return t;
            }
            if((t instanceof Item) && ((Item) t).getKey().equalsIgnoreCase(key)) {
                return t;
            }
            if((t instanceof Setting) && ((Setting) t).getName().equalsIgnoreCase(key)) {
                return t;
            }
        }
        return null;
    }

    public List<T> getList() {
        return list;
    }

    public Main getPlugin() {
        return plugin;
    }
}