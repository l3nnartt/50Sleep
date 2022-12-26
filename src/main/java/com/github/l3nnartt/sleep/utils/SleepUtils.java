package com.github.l3nnartt.sleep.utils;

import org.bukkit.entity.Player;

public class SleepUtils {

  public int calculatePlayersSleepNeeded(Player player) {
    return player.getWorld().getPlayers().size() / 2;
  }

}