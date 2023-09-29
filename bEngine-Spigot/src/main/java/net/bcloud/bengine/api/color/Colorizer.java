package net.bcloud.bengine.api.color;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public abstract class Colorizer {

    public static final Pattern PATTERN_HEX      = Pattern.compile("#([A-Fa-f0-9]{6})");

    /**
     * Colorize for console.
     */
    public static String applyForConsole(@NotNull String message) {
        String text = message.replace("§0", ConsoleColor.BLACK)
                .replace("§1", ConsoleColor.BLUE)
                .replace("§2", ConsoleColor.GREEN)
                .replace("§3", ConsoleColor.LIGHT_BLUE)
                .replace("§4", ConsoleColor.RED)
                .replace("§5", ConsoleColor.PURPLE)
                .replace("§6", ConsoleColor.YELLOW)
                .replace("§7", ConsoleColor.WHITE)
                .replace("§8", ConsoleColor.BLACK)
                .replace("§9", ConsoleColor.BLUE)
                .replace("§a", ConsoleColor.GREEN)
                .replace("§b", ConsoleColor.LIGHT_BLUE)
                .replace("§c", ConsoleColor.RED)
                .replace("§d", ConsoleColor.PURPLE)
                .replace("§e", ConsoleColor.YELLOW)
                .replace("§f", ConsoleColor.WHITE)
                .replace("§l", ConsoleColor.BOLD)
                .replace("§k", "")
                .replace("§r", ConsoleColor.RESET)
                .replace("&0", ConsoleColor.BLACK)
                .replace("&1", ConsoleColor.BLUE)
                .replace("&2", ConsoleColor.GREEN)
                .replace("&3", ConsoleColor.LIGHT_BLUE)
                .replace("&4", ConsoleColor.RED)
                .replace("&5", ConsoleColor.PURPLE)
                .replace("&6", ConsoleColor.YELLOW)
                .replace("&7", ConsoleColor.WHITE)
                .replace("&8", ConsoleColor.BLACK)
                .replace("&9", ConsoleColor.BLUE)
                .replace("&a", ConsoleColor.GREEN)
                .replace("&b", ConsoleColor.LIGHT_BLUE)
                .replace("&c", ConsoleColor.RED)
                .replace("&d", ConsoleColor.PURPLE)
                .replace("&e", ConsoleColor.YELLOW)
                .replace("&f", ConsoleColor.WHITE)
                .replace("&l", ConsoleColor.BOLD)
                .replace("&k", "")
                .replace("&r", ConsoleColor.RESET);
        return text + ConsoleColor.RESET;
    }

    /**
     * Colorize for message to user.
     */
    public static String apply(@NotNull String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    @NotNull
    public static List<String> apply(@NotNull List<String> list) {
        list.replaceAll(Colorizer::apply);
        return list;
    }

    public static Set<String> apply(@NotNull Set<String> messages) {
        return messages.stream().map(Colorizer::apply).collect(Collectors.toSet());
    }

//    @NotNull
//    public static String hex(@NotNull String str) {
//        Matcher matcher = PATTERN_HEX.matcher(str);
//        StringBuilder buffer = new StringBuilder(str.length() + 4 * 8);
//        while (RegexUtil.matcherFind(matcher)) {
//            String group = matcher.group(1);
//            matcher.appendReplacement(buffer,
//                    ChatColor.COLOR_CHAR + "x" + ChatColor.COLOR_CHAR + group.charAt(0) +
//                            ChatColor.COLOR_CHAR + group.charAt(1) + ChatColor.COLOR_CHAR + group.charAt(2) +
//                            ChatColor.COLOR_CHAR + group.charAt(3) + ChatColor.COLOR_CHAR + group.charAt(4) +
//                            ChatColor.COLOR_CHAR + group.charAt(5));
//        }
//        return matcher.appendTail(buffer).toString();
//    }

    /**
     * Remove color in text.
     */
    public static String removeColor(@NotNull String message) {
        return message.replace("&0", "")
                .replace("&1", "")
                .replace("&2", "")
                .replace("&3", "")
                .replace("&4", "")
                .replace("&5", "")
                .replace("&6", "")
                .replace("&7", "")
                .replace("&8", "")
                .replace("&9", "")
                .replace("&a", "")
                .replace("&b", "")
                .replace("&c", "")
                .replace("&d", "")
                .replace("&e", "")
                .replace("&f", "")
                .replace("&l", "")
                .replace("&k", "")
                .replace("&r", "")
                .replace("§0", "")
                .replace("§1", "")
                .replace("§2", "")
                .replace("§3", "")
                .replace("§4", "")
                .replace("§5", "")
                .replace("§6", "")
                .replace("§7", "")
                .replace("§8", "")
                .replace("§9", "")
                .replace("§a", "")
                .replace("§b", "")
                .replace("§c", "")
                .replace("§d", "")
                .replace("§e", "")
                .replace("§f", "")
                .replace("§l", "")
                .replace("§k", "")
                .replace("§r", "");
    }
}

