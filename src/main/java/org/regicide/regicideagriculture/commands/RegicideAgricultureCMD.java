package org.regicide.regicideagriculture.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class RegicideAgricultureCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        // TODO
        // if strings[0].equals("reload") => логика перезапуска сервеара

        // if strings[0].equals("types") => вывод типов в консоль/в чат игроку | (commandSender instanceof Player)
        return true;

    }
}
