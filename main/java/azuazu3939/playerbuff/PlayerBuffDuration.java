package azuazu3939.playerbuff;

import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerBuffDuration implements Listener {

    public static void PlayerBuffSetDurationHealth(long duration) {

        long l = duration * 20L;

        Bukkit.getScheduler().scheduleSyncDelayedTask(PlayerBuff.getInstance(), () -> {

            if (PlayerBuffSetHealth.hasBuffHealth(PlayerBuffSetCommand.getInstance().target))
                PlayerBuffSetHealth.removeHealthAttributes(PlayerBuffSetCommand.getInstance().target);
        }, l);

    }

    public static void PlayerBuffSetDurationDamage(long duration) {

        long l = duration * 20L;

        Bukkit.getScheduler().scheduleSyncDelayedTask(PlayerBuff.getInstance(), () -> {

            if (PlayerBuffSetDamage.hasBuffDamage(PlayerBuffSetCommand.getInstance().target))
                PlayerBuffSetDamage.removeDamageAttributes(PlayerBuffSetCommand.getInstance().target);
        }, l);
    }

    public static void PlayerBuffSetDurationArmor(long duration) {

        long l = duration * 20L;

        Bukkit.getScheduler().scheduleSyncDelayedTask(PlayerBuff.getInstance(), () -> {

            if (PlayerBuffSetArmor.hasBuffArmor(PlayerBuffSetCommand.getInstance().target))
                PlayerBuffSetArmor.removeArmorAttributes(PlayerBuffSetCommand.getInstance().target);
        }, l);
    }

    public static void PlayerBuffSetDurationToughness(long duration) {

        long l = duration * 20L;

        Bukkit.getScheduler().scheduleSyncDelayedTask(PlayerBuff.getInstance(), () -> {

            if (PlayerBuffSetArmorToughness.hasBuffArmorToughness(PlayerBuffSetCommand.getInstance().target))
                PlayerBuffSetArmorToughness.removeArmorToughnessAttributes(PlayerBuffSetCommand.getInstance().target);
        }, l);
    }

    public static void PlayerBuffSetDurationSpeed(long duration) {

        long l = duration * 20L;

        Bukkit.getScheduler().scheduleSyncDelayedTask(PlayerBuff.getInstance(), () -> {

            if (PlayerBuffSetSpeed.hasBuffSpeed(PlayerBuffSetCommand.getInstance().target))
                PlayerBuffSetSpeed.removeSpeedAttributes(PlayerBuffSetCommand.getInstance().target);
        }, l);

    }

    public static void PlayerBuffSetDurationStartHealth(LivingEntity entity) {
        if (PlayerBuffSetHealth.hasBuffHealth(entity)) return;
        PlayerBuffSetHealth.addHealthAttributes(entity, PlayerBuffSetCommand.getInstance().level);
    }

    public static void PlayerBuffSetDurationStartDamage(LivingEntity entity) {
        if (PlayerBuffSetDamage.hasBuffDamage(entity)) return;
        PlayerBuffSetDamage.addDamageAttributes(entity, PlayerBuffSetCommand.getInstance().level);
    }

    public static void PlayerBuffSetDurationStartArmor(LivingEntity entity) {
        if (PlayerBuffSetArmor.hasBuffArmor(entity)) return;
        PlayerBuffSetArmor.addArmorAttributes(entity, PlayerBuffSetCommand.getInstance().level);
    }

    public static void PlayerBuffSetDurationStartArmorToughness(LivingEntity entity) {
        if (PlayerBuffSetArmorToughness.hasBuffArmorToughness(entity)) return;
        PlayerBuffSetArmorToughness.addArmorToughnessAttributes(entity, PlayerBuffSetCommand.getInstance().level);
    }

    public static void PlayerBuffSetDurationStartSpeed(LivingEntity entity) {
        if (PlayerBuffSetSpeed.hasBuffSpeed(entity)) return;
        PlayerBuffSetSpeed.addSpeedAttributes(entity, PlayerBuffSetCommand.getInstance().level);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {

       LivingEntity entity = event.getPlayer();

        if (PlayerBuffSetHealth.hasBuffHealth(entity)) PlayerBuffSetHealth.removeHealthAttributes(entity);
        if (PlayerBuffSetDamage.hasBuffDamage(entity)) PlayerBuffSetDamage.removeDamageAttributes(entity);
        if (PlayerBuffSetArmor.hasBuffArmor(entity)) PlayerBuffSetArmor.removeArmorAttributes(entity);
        if (PlayerBuffSetArmorToughness.hasBuffArmorToughness(entity)) PlayerBuffSetArmorToughness.removeArmorToughnessAttributes(entity);
        if (PlayerBuffSetSpeed.hasBuffSpeed(entity)) PlayerBuffSetSpeed.removeSpeedAttributes(entity);
    }
}
