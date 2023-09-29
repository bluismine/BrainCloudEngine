package net.bcloud.bengine.command.subcommand;

import net.bcloud.bengine.api.command.SubCommand;
import net.bcloud.bengine.api.logger.Logger;
import net.bcloud.bengine.bEngine;
import org.bukkit.command.CommandSender;

public class About implements SubCommand {
    @Override
    public String getName() {
        return "about";
    }

    @Override
    public String getDescription() {
        return "Some information about the engine.";
    }

    @Override
    public String getSyntax() {
        return "about";
    }

    @Override
    public String getPermission() {
        return "none";
    }

    @Override
    public void perform(CommandSender commandSender, String[] args) {
        Logger.sendMessage(commandSender, "&bb&eEngine&r version &b" + bEngine.getPlugin(bEngine.class).getDescription().getVersion());
        Logger.sendMessage(commandSender, "&0Create by &fBluismine");
    }
}
