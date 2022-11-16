package azuazu3939.playerbuff;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class PlayerBuff extends JavaPlugin {

    private static PlayerBuff instance;

    public PlayerBuff() {
        instance = this;
    }

    public static PlayerBuff getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {

        Objects.requireNonNull(getServer().getPluginCommand("playerbuff")).setExecutor(new PlayerBuffCommand(PlayerBuffCommand.getInstance()));
        Objects.requireNonNull(getServer().getPluginCommand("pbs")).setExecutor(new PlayerBuffSetCommand());
        getServer().getPluginManager().registerEvents(new PlayerBuffTest(), this);

        saveDefaultConfig();
        saveConfig();
    }

    @Override
    public void onDisable() {
    }

    public void reload() {
        saveDefaultConfig();
        reloadConfig();
    }
}
