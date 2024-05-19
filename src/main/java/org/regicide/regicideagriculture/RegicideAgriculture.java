package org.regicide.regicideagriculture;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.regicide.regicideagriculture.commands.RegicideAgricultureCMD;
import org.regicide.regicideagriculture.listeners.GrowthListener;
import org.regicide.regicideagriculture.listeners.GrowthListenerDeprecated;
import java.util.logging.Logger;

public final class RegicideAgriculture extends JavaPlugin {

    private static RegicideAgriculture plugin;


    public void onEnable()
    {
        plugin = this;
        Logger l = getLogger();

        saveDefaultConfig();
        GrowthManager.readBiomeTypes();
        l.info("All biomes was successfully loaded.");

        GrowthManager.readMaterialTypes();
        l.info("All crops successfully loaded.");

        Bukkit.getPluginManager().registerEvents(new GrowthListenerDeprecated(), this);
        Bukkit.getPluginManager().registerEvents(new GrowthListener(), this);
        l.info("The plugin get started!");
        l.info("RegicideAgricultureCMD has been enabled!");

        getCommand("types").setExecutor(new RegicideAgricultureCMD());
    }

    //Перезапуск всех команд, всех листенеров, всех конфигураций и добавление команды /RegicideAgriculture reload
    public void reload() {
        getCommand("reload").setExecutor(new RegicideAgricultureCMD());

    }

    public void onDisable() {
        // Plugin shutdown logic
    }

    public static RegicideAgriculture instance()
    {
        return plugin;
    }
}
