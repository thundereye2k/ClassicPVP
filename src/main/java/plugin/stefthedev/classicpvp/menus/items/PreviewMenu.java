package plugin.stefthedev.classicpvp.menus.items;

import org.bukkit.entity.Player;
import plugin.stefthedev.classicpvp.Main;
import plugin.stefthedev.classicpvp.menus.Menu;
import plugin.stefthedev.classicpvp.utilities.Kit;

public class PreviewMenu extends Menu {

    public PreviewMenu(Main plugin) {
        super(plugin,"preview");
    }

    @Override
    public void addItems(Player player) {

    }

    public void open(Player player, String key) {
        Kit kit = getPlugin().getKitManager().getElement(key);
        if(kit == null) return;
        getInventory().clear();
        kit.getItems().forEach(item -> getInventory().addItem(item.build()));
        player.openInventory(getInventory());
    }
}
