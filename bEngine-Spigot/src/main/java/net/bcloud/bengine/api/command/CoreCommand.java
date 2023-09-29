package net.bcloud.bengine.api.command;

import net.bcloud.bengine.api.logger.Logger;
import net.bcloud.bengine.bPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class CoreCommand extends Command implements TabCompletion {

    private static bPlugin plugin;
    protected CoreCommand(@NotNull String name) {
        super(name);
    }

    protected CoreCommand(@NotNull String name, @NotNull String description, @NotNull String usageMessage, @NotNull List<String> aliases) {
        super(name, description, usageMessage, aliases);
    }

    public static void registerCommand(@NotNull final String name, @NotNull CoreCommand command) {
        try {
            final Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            bukkitCommandMap.setAccessible(true);
            final CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());
            commandMap.register(name, command);
//            Objects.requireNonNull(plugin.getCommand(name)).setTabCompleter(command);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract boolean execute(@NotNull CommandSender commandSender, @NotNull String label, @NotNull String[] args);

    public abstract ArrayList<SubCommand> getSubCommands();

    public static void setPlugin(bPlugin plugin) {
        CoreCommand.plugin = plugin;
    }
}
