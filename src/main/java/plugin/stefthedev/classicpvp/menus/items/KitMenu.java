package plugin.stefthedev.classicpvp.menus.items;

import org.bukkit.entity.Player;
import plugin.stefthedev.classicpvp.Main;
import plugin.stefthedev.classicpvp.menus.Menu;
import plugin.stefthedev.classicpvp.utilities.Kit;

public class KitMenu extends Menu {

    public KitMenu(Main plugin) {
        super(plugin,"kits");
    }

    @Override
    public void addItems(Player player) {
        getInventory().clear();
        for(Kit kit: getPlugin().getKitManager().getList()) {
            if(player.hasPermission(kit.getPermission())) {
                getInventory().setItem(kit.getIcon().getSlot(), kit.getIcon().build());
            }
        }
    }
}
