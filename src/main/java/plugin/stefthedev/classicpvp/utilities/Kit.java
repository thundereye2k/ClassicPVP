package plugin.stefthedev.classicpvp.utilities;

import java.util.List;

public class Kit {

    private String key, permission;
    private Item icon;
    private List<Item> items;

    public Kit(String key, String permission, Item icon, List<Item> items) {
        this.key = key;
        this.permission = permission;
        this.icon = icon;
        this.items = items;
    }

    public String getKey() {
        return key;
    }

    public String getPermission() {
        return permission;
    }

    public Item getIcon() {
        return icon;
    }

    public List<Item> getItems() {
        return items;
    }
}
