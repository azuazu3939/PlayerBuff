package azuazu3939.playerbuff;

import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

public class PlayerBuffDuration implements Listener {

    private final PlayerBuff plugin;

    public PlayerBuffDuration(PlayerBuff plugin) {
        this.plugin = plugin;
    }

    public void PlayerBuffSetDuration(long duration) {

        long l = duration * 20L;

        Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) this, () -> {
            if (plugin.pbsh.hasBuffHealth(plugin.pbsc.target)) PlayerBuffSetHealth.removeHealthAttributes(plugin.pbsc.target);
        }, l);
    }

    public void PlayerBuffSetDurationStartHealth(LivingEntity entity) {
        if (plugin.pbsh.hasBuffHealth(entity)) return;
        plugin.pbsh.addHealthAttributes(entity, plugin.pbsc.level);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {

       LivingEntity entity = event.getPlayer();

        if (plugin.pbsh.hasBuffHealth(entity)) PlayerBuffSetHealth.removeHealthAttributes(entity);
    }
}
