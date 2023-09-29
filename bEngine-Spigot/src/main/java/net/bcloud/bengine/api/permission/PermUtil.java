package net.bcloud.bengine.api.permission;

import com.google.common.base.Preconditions;
import net.bcloud.bengine.api.logger.Logger;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PermUtil {

    /**
     * Function to register PermUtil if you're using checkPermission method.
     * @param file what files to we can connect to get no-permission messages.
     * @param path what path to connect to get no-permission messages.
     */
    public PermUtil(YamlConfiguration file, String path) {
        Preconditions.checkArgument(file != null, "We cannot found file " + file + ".");
        Preconditions.checkArgument(path != null, "We cannot found the path with \"" + path + "\".");
        messages = file.getStringList(path);
    }

    private static List<String> messages = new ArrayList<>();

    /**
     * Check sender's permission with announce if sender don't have that permission.
     * @param sender who I need check him?
     * @param permission sender's needed to execute command or do sth.
     */
    public static boolean checkPermission(CommandSender sender, String permission) {
        Preconditions.checkArgument(sender != null, "You forgot add sender to check permission.");
        Preconditions.checkArgument(permission != null, "You forgot add permission to check.");

        if (sender.hasPermission(permission))return true;
        else {
            extracted(sender, permission);
            return false;
        }
    }

    private static void extracted(CommandSender sender, String permission) {
        for (String message : messages) {
            Logger.sendMessage(sender, message.replaceAll("%permission%", permission));
        }
    }

    /**
     * Check sender's permission with announce and sound if sender don't have that permission.
     * @param sender who I need check him?
     * @param permission sender's needed to execute command or do sth.
     * @param sound sound needed to play.
     */
    public static boolean checkPermission(CommandSender sender, String permission, Sound sound) {
        Preconditions.checkArgument(sender != null, "You forgot add sender to check permission.");
        Preconditions.checkArgument(permission != null, "You forgot add permission to check.");

        if (sender.hasPermission(permission)) {
            return true;
        } else {
            for (String message : messages) {
                sender.sendMessage(message.replaceAll("%permission%", permission));
            }
            return false;
        }
    }

    /**
     * Check player's permission and don't have announced.
     * @param player who I need check him?
     * @param permission sender's needed to execute command or do sth.
     */
    public static boolean checkPermissionSilent(Player player, String permission) {
        Preconditions.checkArgument(player != null, "You forgot add sender to check permission.");
        Preconditions.checkArgument(permission != null, "You forgot add permission to check.");

        return permission.equalsIgnoreCase("none") || player.hasPermission(permission);
    }

    /**
     * Check sender's permission and don't have announced.
     * @param sender who I need check him?
     * @param permission sender's needed to execute command or do sth.
     */
    public static boolean checkPermissionSilent(CommandSender sender, String permission) {
        Preconditions.checkArgument(sender != null, "You forgot add sender to check permission.");
        Preconditions.checkArgument(permission != null, "You forgot add permission to check.");

        return permission.equalsIgnoreCase("none") || sender.hasPermission(permission);
    }

    /**
     * Set message when sender don't have permission you want.
     */
    public static void setMessage(ArrayList<String> messagess) {
        messages = messagess;
    }
}
