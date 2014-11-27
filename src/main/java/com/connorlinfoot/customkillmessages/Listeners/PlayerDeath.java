package com.connorlinfoot.customkillmessages.Listeners;

import com.connorlinfoot.customkillmessages.CustomKillMessages;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PlayerDeath implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        if( CustomKillMessages.getPlugin().getConfig().isSet(player.getName()) ){
            String deathMessage = CustomKillMessages.getPlugin().getConfig().getString(player.getName());
            deathMessage = deathMessage.replaceAll("%killed%",player.getDisplayName());
            String killer = "";
            if( player.getKiller().getDisplayName() != null ) killer = player.getKiller().getDisplayName();
            deathMessage = deathMessage.replaceAll("%killer%",killer);
            event.setDeathMessage(deathMessage);
        }
    }

}
