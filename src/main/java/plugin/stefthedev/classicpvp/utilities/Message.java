package plugin.stefthedev.classicpvp.utilities;

import org.bukkit.configuration.file.FileConfiguration;

public enum Message {

    COMMAND_PERMISSION("command-permission", "You do not seem to have permissions to this command."),
    COMMAND_PLAYER("command-player", "You must be a player to execute this command."),
    COMMAND_USAGE("command-usage", "Usage: &f{usage}"),
    DEATH_PLAYER("death-player", "You have been killed by &c{player}"),
    KICK_PLAYER("kick-player", "Thank you for playing, we hope you enjoyed."),
    KILL_PLAYER("kill-player", "You have killed &a{player}"),
    KIT_PLAYER("kit-player", "You have chosen the &b{kit}&7 kit."),
    LOBBY_FALSE("lobby-false", "The lobby has not been set, please contact an administrator."),
    LOBBY_SET("lobby-set", "You have set the global lobby."),
    PREFIX("prefix", "&e&lPVP: &7"),
    RELOAD("reload", "Reloading is not supported in this version, please restart the server."),
    SPAWN_ADD("spawn-add", "You have added new spawn: &b{id}"),
    SPAWN_CLEAR("spawn-clear", "All spawns have been cleared"),
    SPAWN_FALSE("spawn-false", "No spawns have been set."),
    SPAWN_REMOVE("spawn-remove", "You have removed spawn: &b{id}");

    private String path;
    private String def;
    private static FileConfiguration messages;

    Message(String path, String start) {
        this.path = path;
        this.def = start;
    }

    public static void setFile(FileConfiguration config) {
        messages = config;
    }

    public String getMessage() {
        return Chat.color(messages.getString(path));
    }

    public String getDefault() {
        return Chat.color(this.def);
    }

    public String getPath() {
        return this.path;
    }
}
