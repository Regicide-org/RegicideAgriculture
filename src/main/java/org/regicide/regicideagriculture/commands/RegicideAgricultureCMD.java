package org.regicide.regicideagriculture.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideagriculture.RegicideAgriculture;
import java.util.Set;


public class RegicideAgricultureCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        // TODO
        // if strings[0].equals("reload") => логика перезапуска сервеара
        if (strings[0].equals("reload")) {
            if (!commandSender.hasPermission("regicideagriculture.command.regicideagriculture")) {
                commandSender.sendMessage(ChatColor.RED + "You don't have the permission!");
            }

            RegicideAgriculture.instance().reload();
            commandSender.sendMessage("plugin RegicideAgriculture has reloaded!");
        }

        // if strings[0].equals("types") => вывод типов в консоль/в чат игроку | (commandSender instanceof Player)
        if (commandSender instanceof Player) {
            if (strings[0].equals("types")) {
                ConfigurationSection biomeSection = RegicideAgriculture.instance().getConfig().getConfigurationSection("biome-types");
                Set<String> biomeTypes = biomeSection.getKeys(false);
                commandSender.sendMessage("Types of biomes: ");
                for (String biomeType : biomeTypes)
                    commandSender.sendMessage(biomeType);
            }
        }

        return true;

    }
}
