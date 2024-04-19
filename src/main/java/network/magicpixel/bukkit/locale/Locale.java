package network.magicpixel.bukkit.locale;

import network.magicpixel.bukkit.MPAccess;
import network.magicpixel.bukkit.utils.MessageStyle;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

/**
 * @author PlaidMrdeer
 */
public class Locale
{
    private final File localePath;

    private static FileConfiguration locale;

    public Locale(File localePath)
    {
        this.localePath = localePath;
    }

    public void loadLocale()
    {
        if (!new File(localePath, "locale.yml").exists())
        {
            MPAccess.getPlugin().saveResource("locale.yml", false);
        }

        locale = YamlConfiguration.loadConfiguration(new File(localePath, "locale.yml"));
    }

    public static String getMessage(String path)
    {
        return MessageStyle.setStyle(locale.getString(path));
    }
}
