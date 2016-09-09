package me.GeneralOP.commands.helper;

import com.google.common.base.Joiner;
import java.util.ArrayList;
import me.GeneralOP.GeneralOP;
import me.GeneralOP.listener.chatListener;
import me.GeneralOP.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class C_mute implements CommandExecutor
{

    GeneralOP plugin;
    FileConfiguration config;

    public C_mute(GeneralOP plugin)
    {
    }

    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] args)
    {
        String muteMessage = Joiner.on(" ").join(args);

        if (Bukkit.getOnlinePlayers().contains(args[0]))
        {
            while (chatListener.muted.contains(args[0]))
            {
                plugin.getConfig().set("users." + args[0] + ".muted", true);
            }
            if (Utils.isStaff((Player) cs))
            {
                if (!chatListener.muted.contains(args[0]))
                {
                    chatListener.muted.add(Bukkit.getServer().getPlayer(args[0]));
                } 
                else
                {
                    cs.sendMessage(ChatColor.GOLD + "This user has now been" + ChatColor.RED + "Unmuted" + ChatColor.GOLD + "!");
                }
            }
        }
        return true;
    }

}
