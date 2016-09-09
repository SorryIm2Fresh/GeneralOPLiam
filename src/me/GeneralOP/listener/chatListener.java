package me.GeneralOP.listener;

import java.util.ArrayList;
import me.GeneralOP.GeneralOP;
import me.GeneralOP.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class chatListener implements Listener
{
    public static ArrayList muted = new ArrayList();

    GeneralOP plugin;
    FileConfiguration config;

    public chatListener(GeneralOP plugin)
    {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
        config = plugin.getConfig();
    }

    @EventHandler
    public void onStaffChat(AsyncPlayerChatEvent e)
    {

    }

    @EventHandler
    public void onMutedChat(AsyncPlayerChatEvent e)
    {
        if (muted.contains(e.getPlayer().getName()))
        {
            e.getPlayer().sendMessage(Utils.PREFIX + ChatColor.RED + "You cannot send a message as you are muted!");
            e.setCancelled(true);
        }
    }

}
