package org.regicide.regicideagriculture;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.regicide.regicideagriculture.listeners.Grow;
import java.util.logging.Logger;

public final class RegicideAgriculture extends JavaPlugin {

    private static RegicideAgriculture plugin;


    public void onEnable()
    {
        plugin = this;
        Bukkit.getPluginManager().registerEvents(new Grow(), this);
        Logger logger = getLogger();
        logger.info("The plugin get started");
        logger.info("CustomTickSpeedPlugin has been enabled!");
    }


    public void onDisable() {
        // Plugin shutdown logic
    }

    public static RegicideAgriculture instance()
    {
        return plugin;
    }
}
