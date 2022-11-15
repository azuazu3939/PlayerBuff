package azuazu3939.playerbuff;

import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerBuff extends JavaPlugin {

    @Override
    public void onEnable() {
        PlayerBuff playerBuff = this;
        getServer().getPluginManager().registerEvents(new PlayerBuffEvent(playerBuff), this);
        saveDefaultConfig();
        saveConfig();
    }

    @Override
    public void onDisable() {
    }
}
