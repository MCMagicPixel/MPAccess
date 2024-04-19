package network.magicpixel.bukkit.command;

import network.magicpixel.bukkit.MPAccess;
import network.magicpixel.bukkit.locale.Locale;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * @author PlaidMrdeer
 */
public class MPACommand implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (!sender.hasPermission("magicpixel.command.mpa"))
        {
            sender.sendMessage(Locale.getMessage("no_permission"));
            return true;
        }

        if (args.length == 0 || args.length > 2)
        {
            sender.sendMessage(Locale.getMessage("command_error"));
            return true;
        }

        if (args.length == 1)
        {
            if ("reload".equalsIgnoreCase(args[0]))
            {
                MPAccess.getPlugin().reloadConfig();
                sender.sendMessage(Locale.getMessage("reload_complete"));
            }
        }

        return true;
    }
}
