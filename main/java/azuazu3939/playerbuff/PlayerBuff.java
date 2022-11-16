package azuazu3939.playerbuff;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class PlayerBuff extends JavaPlugin {

    PlayerBuffSetHealth pbsh;
    PlayerBuffDuration pbd;
    PlayerBuffSetCommand pbsc;

    @Override
    public void onEnable() {
        pbd = new PlayerBuffDuration(this);
        pbsh = new PlayerBuffSetHealth(this);
        getServer().getPluginManager().registerEvents(new PlayerBuffTest(this), this);
        Objects.requireNonNull(Bukkit.getPluginCommand("playerbuff")).setExecutor(new PlayerBuffCommand(this));
        Objects.requireNonNull(Bukkit.getPluginCommand("pbs")).setExecutor(pbsc = new PlayerBuffSetCommand(this));
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
