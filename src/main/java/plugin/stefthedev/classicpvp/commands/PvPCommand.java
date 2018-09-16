package plugin.stefthedev.classicpvp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import plugin.stefthedev.classicpvp.Main;
import plugin.stefthedev.classicpvp.managers.items.LocationManager;
import plugin.stefthedev.classicpvp.utilities.Chat;
import plugin.stefthedev.classicpvp.utilities.Config;
import plugin.stefthedev.classicpvp.utilities.Message;

import java.util.List;

public class PvPCommand implements CommandExecutor {

    private Main plugin;
    private LocationManager locationManager;
    private List<String> help;

    public PvPCommand(Main plugin) {
        this.plugin = plugin;
        this.locationManager = plugin.getLocationManager();
        this.help = plugin.getConfig().getStringList("Help");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(!player.hasPermission("classicpvp.admin")) {
            player.sendMessage(Message.PREFIX.getMessage() + Message.COMMAND_PERMISSION.getMessage());
            return true;
        }
        if(args.length == 1) {
            switch (args[0].toLowerCase()) {
                case "addspawn": {
                    locationManager.getList().add(player.getLocation());
                    player.sendMessage(Message.PREFIX.getMessage() + Message.SPAWN_ADD.getMessage()
                        .replace("{id}", locationManager.getList().size() + ""));
                } break;
                case "clearspawns": {
                    if(locationManager.getList().isEmpty()) {
                        player.sendMessage(Message.PREFIX.getMessage() + Message.SPAWN_FALSE.getMessage());
                        break;
                    }
                    locationManager.getList().clear();
                    player.sendMessage(Message.PREFIX.getMessage() + Message.SPAWN_CLEAR.getMessage());
                } break;
                case "delspawn": {
                    if(locationManager.getList().isEmpty()) {
                        player.sendMessage(Message.PREFIX.getMessage() + Message.SPAWN_FALSE.getMessage());
                        break;
                    }
                    locationManager.getList().remove(locationManager.getList().iterator().next());
                    player.sendMessage(Message.PREFIX.getMessage() + Message.SPAWN_REMOVE.getMessage()
                            .replace("{id}", locationManager.getList().size() + 1 + ""));
                } break;
                case "setlobby": {
                    locationManager.setLocation(player.getLocation());
                    player.sendMessage(Message.PREFIX.getMessage() + Message.LOBBY_SET.getMessage());
                } break;
                case "reload": {
                    plugin.reloadConfig();
                    plugin.getKitManager().deserialise();
                    plugin.getLocationManager().deserialise();
                    plugin.getSettingsManager().deserialise();
                    plugin.getItemManager().deserialise();
                    plugin.getConfigManager().getList().forEach(Config::reload);
                    plugin.getLocationManager().serialise();
                    plugin.getSettingsManager().serialise();
                    plugin.getItemManager().serialise();
                    plugin.getKitManager().serialise();
                    player.sendMessage(Message.PREFIX.getMessage() + Message.RELOAD.getMessage());
                } break;
                default: {
                    help.forEach(s -> player.sendMessage(Chat.color(s)));
                } break;
            }
        } else  {
            help.forEach(s -> player.sendMessage(Chat.color(s)));
        }
        return false;
    }

}
