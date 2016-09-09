package me.GeneralOP.commands.helper;

import me.GeneralOP.GeneralOP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class C_tempban implements CommandExecutor
{
    
    GeneralOP plugin;
    FileConfiguration config;

    public C_tempban(GeneralOP plugin)
    {
    }

    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] args)
    {
        if (plugin.getConfig().getString("users." + cs.getName() + ".staff") == "helper")
        {
          string.replace("&k", "&r");
          string.replace("&n", "&r");
          string.replace("&m", "&r");
          string.replace("&0", "&r");
        }

        return true;
    }

}