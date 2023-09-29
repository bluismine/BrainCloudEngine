package net.bcloud.bengine.api.logger;

import net.bcloud.bengine.api.color.Colorizer;
import net.bcloud.bengine.api.color.ConsoleColor;
import net.bcloud.bengine.bPlugin;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class Logger extends ConsoleColor {

    private static bPlugin plugin;

    public Logger(bPlugin plugin) {
        Logger.plugin = plugin;
    }

    /**
     * Send INFO message by console.
     */
    public static void sendInfoLog(final String... messages) {
        for (String message : messages) plugin.getLogger().info(Colorizer.applyForConsole(message))  ;
    }

    /**
     * Send WARNING message by console.
     */
    public static void sendWarningLog(final String... messages) {
        for (String message : messages) plugin.getLogger().warning(YELLOW + message);
    }

    /**
     * Send SEVERE message by console.
     */
    public static void sendSevereLog(final String... messages) {
        for (String message : messages) plugin.getLogger().severe(RED + message + RESET);
    }

    /**
     * Send messages to command sender with colorized.
     */
    public static void sendMessage(CommandSender commandSender, String... lines) {
        if (commandSender instanceof Player player) {
            for (String message : lines) {
                player.sendMessage(Colorizer.apply(message));
            }
        } else {
            for (String message : lines) {
                plugin.getLogger().info(Colorizer.applyForConsole(message));
            }
        }
    }

    public static void sendMessage(CommandSender commandSender, List<String> lines) {
        if (commandSender instanceof Player player) {
            for (String message : lines) {
                player.sendMessage(Colorizer.apply(message));
            }
        } else {
            for (String message : lines) {
                plugin.getLogger().info(Colorizer.applyForConsole(message));
            }
        }
    }
}
