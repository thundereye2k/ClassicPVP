package plugin.stefthedev.classicpvp.utilities;

public class Setting {

    private String name;
    private boolean enabled;

    public Setting(String name, boolean enabled) {
        this.name = name;
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
