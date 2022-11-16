package azuazu3939.playerbuff;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static org.bukkit.Bukkit.getPlayer;

public class PlayerBuffSetCommand implements CommandExecutor {

    String type;
    int level;
    long duration;

    LivingEntity target;
    String string;

    PlayerBuff plugin;

    @Override
    public boolean onCommand(CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender.hasPermission("playerbuff.command.pbs")) && sender instanceof Player) {
            sender.sendMessage(ChatColor.RED + "権限がありません。");
            return true;
        }

        try {
            string = args[0];
            type = args[1];
            level = Integer.parseInt(args[2]);
            duration = Long.parseLong(args[3]);
        } catch (Exception e) {
            sender.sendMessage("Invalid arguments /pbs <PlayerName> <BuffType> <level> <duration>");
            return true;
        }

        try {
            target = getPlayer(string);
            if (target == null) {
                sender.sendMessage("このプレイヤーはログインしていません。");
                return true;
            }
        } catch (Exception e) {
            sender.sendMessage("このプレイヤーはログインしていません。");
            return true;
        }

        if (Objects.equals(type, "Health") || Objects.equals(type, "health") || Objects.equals(type, "HEALTH")) {
            plugin.pbd.PlayerBuffSetDurationStartHealth(target);
            plugin.pbd.PlayerBuffSetDuration(duration);
            return true;
        }
        if (Objects.equals(type, "Damage") || Objects.equals(type, "damage") || Objects.equals(type, "DAMAGE")) {
            sender.sendMessage("未実装");
            return true;
        }
        if (Objects.equals(type, "Armor") || Objects.equals(type, "armor") || Objects.equals(type, "ARMOR")) {
            sender.sendMessage("未実装");
            return true;
        }
        if (Objects.equals(type, "Toughness") || Objects.equals(type, "toughness") || Objects.equals(type, "TOUGHNESS")) {
            sender.sendMessage("未実装");
            return true;
        }
        if (Objects.equals(type, "Speed") || Objects.equals(type, "speed") || Objects.equals(type, "SPEED")) {
            sender.sendMessage("未実装");
            return true;
        }
        return true;
    }

}
