package com.connorlinfoot.customkillmessages.Commands;

import com.connorlinfoot.customkillmessages.CustomKillMessages;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CKMCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if( args.length >= 1 && args[0].equalsIgnoreCase("reload") ){
            if( !sender.hasPermission("customkillmssages.reload") ){
                sender.sendMessage(CustomKillMessages.Prefix + ChatColor.RED + "Invalid permissions");
                return false;
            }
            CustomKillMessages.getPlugin().saveConfig();
            sender.sendMessage(CustomKillMessages.Prefix + ChatColor.GREEN + "Config reloaded");
            return true;
        }
        sender.sendMessage(ChatColor.AQUA + "\"" + CustomKillMessages.getPlugin().getDescription().getName() + "\" - Version: " + CustomKillMessages.getPlugin().getDescription().getVersion());
        return true;
    }

}
