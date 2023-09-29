package net.bcloud.bengine.command;

import net.bcloud.bengine.api.command.CoreCommand;
import net.bcloud.bengine.api.command.SubCommand;
import net.bcloud.bengine.api.logger.Logger;
import net.bcloud.bengine.api.permission.PermUtil;
import net.bcloud.bengine.bEngine;
import net.bcloud.bengine.command.subcommand.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class bEngineCommand extends CoreCommand {

    private final ArrayList<SubCommand> subCommands = new ArrayList<>();
    public bEngineCommand(@NotNull String name) {
        super(name);
        setPlugin(bEngine.getPlugin(bEngine.class));

        setDescription("Admin commands for bCrate.");
        setUsage("/bEngine <subcommand> (arguments)");

        subCommands.add(new About());
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String label, @NotNull String[] args) {
        if (PermUtil.checkPermissionSilent(commandSender, "none")) {
            if (args.length >= 1) {
                for (int i = 0; i < subCommands.size(); i++) {
                    if (args[0].equalsIgnoreCase(getSubCommands().get(i).getName()) && PermUtil.checkPermissionSilent(commandSender, subCommands.get(i).getPermission())) {
                        getSubCommands().get(i).perform(commandSender, args);
                    }
                }
            } else {
                Logger.sendMessage(commandSender, "&bb&eEngine&r version &b" + bEngine.getPlugin(bEngine.class).getDescription().getVersion());
                Logger.sendMessage(commandSender, "&7Create by &fBluismine");
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] args) {
        if (args.length == 1) {
            List<String> list = new ArrayList<>();
            for (SubCommand subCommand : subCommands) list.add(subCommand.getName());
            return list;
        }
        return null;
    }

    @Override
    public ArrayList<SubCommand> getSubCommands() {
        return subCommands;
    }
}
