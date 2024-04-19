package network.magicpixel.bukkit.utils;

import org.bukkit.ChatColor;

/**
 * @author PlaidMrdeer
 */
public class MessageStyle
{
    public static String setStyle(String msg)
    {
        return color(msg);
    }

    private static String color(String msg)
    {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}