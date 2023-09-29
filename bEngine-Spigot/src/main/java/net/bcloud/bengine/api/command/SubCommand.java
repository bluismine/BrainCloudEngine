package net.bcloud.bengine.api.command;

import org.bukkit.command.CommandSender;

public interface SubCommand {

    /**
    * @return Name of sub command
    * ex: /blib (sub_command) <- this
    */
    String getName();

    /**
     * @return Description of sub command
     * ex: /blib reload - {"Reload all configuration file and user data."} <- this
     */
    String getDescription();

    /**
     * @return How to use command?
     * ex: /blib getData (player)
     */
    String getSyntax();

    /**
     * @return What permission user need to execute subcommand?
     * ex: blib.command.reload
     */
    String getPermission();

    /**
     * Can sub command do?
     * @param commandSender The thing that ran the command
     * @param args   The args passed into the command when run
     */
    void perform(CommandSender commandSender, String[] args);
}