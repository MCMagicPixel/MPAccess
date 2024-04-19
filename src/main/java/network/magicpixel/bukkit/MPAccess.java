package network.magicpixel.bukkit;

import network.magicpixel.bukkit.command.MPACommand;
import network.magicpixel.bukkit.locale.Locale;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author PlaidMrdeer
 */
public final class MPAccess extends JavaPlugin
{
    private static MPAccess plugin;

    public static MPAccess getPlugin()
    {
        return plugin;
    }

    private void registerCommands()
    {
        getCommand("mpa").setExecutor(new MPACommand());
    }

    @Override
    public void reloadConfig()
    {
        super.reloadConfig();
        new Locale(getDataFolder()).loadLocale();
    }

    @Override
    public void onEnable()
    {
        plugin = this;
        saveDefaultConfig();
        new Locale(getDataFolder()).loadLocale();

        registerCommands();
    }

    @Override
    public void onDisable() {}
}
