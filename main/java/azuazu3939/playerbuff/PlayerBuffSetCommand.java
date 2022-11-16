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

    private static PlayerBuffSetCommand instance;

    public PlayerBuffSetCommand() {
        PlayerBuffSetCommand.instance = this;
    }

    public static PlayerBuffSetCommand getInstance() {
        return instance;
    }

    String type;
    int level;
    long duration;

    LivingEntity target;
    String string;



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
            sender.sendMessage("正しく入力しよう！ /pbs <PlayerName> <BuffType> <level> <duration>");
            sender.sendMessage("PlayerNameはオンラインプレイヤーのみ。");
            sender.sendMessage("BuffTypeは(Health, Damage, Armor, Toughness, Speed)の内から。");
            sender.sendMessage("durationは秒数。ログアウトすると効果がはがれるよ。");
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
            PlayerBuffDuration.PlayerBuffSetDurationStartHealth(target);
            PlayerBuffDuration.PlayerBuffSetDurationHealth(duration);
            return true;
        }
        if (Objects.equals(type, "Damage") || Objects.equals(type, "damage") || Objects.equals(type, "DAMAGE")) {
            PlayerBuffDuration.PlayerBuffSetDurationStartDamage(target);
            PlayerBuffDuration.PlayerBuffSetDurationDamage(duration);
            return true;
        }
        if (Objects.equals(type, "Armor") || Objects.equals(type, "armor") || Objects.equals(type, "ARMOR")) {
            PlayerBuffDuration.PlayerBuffSetDurationStartArmor(target);
            PlayerBuffDuration.PlayerBuffSetDurationArmor(duration);
            return true;
        }
        if (Objects.equals(type, "Toughness") || Objects.equals(type, "toughness") || Objects.equals(type, "TOUGHNESS")) {
            PlayerBuffDuration.PlayerBuffSetDurationStartArmorToughness(target);
            PlayerBuffDuration.PlayerBuffSetDurationToughness(duration);
            return true;
        }
        if (Objects.equals(type, "Speed") || Objects.equals(type, "speed") || Objects.equals(type, "SPEED")) {
            PlayerBuffDuration.PlayerBuffSetDurationStartSpeed(target);
            PlayerBuffDuration.PlayerBuffSetDurationSpeed(duration);
            return true;
        }
        return true;
    }

}
