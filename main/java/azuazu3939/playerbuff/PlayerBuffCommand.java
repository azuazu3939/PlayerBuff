package azuazu3939.playerbuff;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PlayerBuffCommand implements CommandExecutor {

    static PlayerBuff playerBuff;

    public PlayerBuffCommand(PlayerBuff playerBuff) {

        PlayerBuffCommand.playerBuff = playerBuff;
    }

    public static PlayerBuff getInstance() {
        return playerBuff;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player player = (Player) sender;
        if (!(player.hasPermission("playerbuff.command.reload"))) return false;
        PlayerBuff.getInstance().reload();
        sender.sendMessage("コンフィグをリロードしました。");
        return true;
    }
}
