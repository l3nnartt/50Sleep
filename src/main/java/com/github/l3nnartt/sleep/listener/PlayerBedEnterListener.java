package com.github.l3nnartt.sleep.listener;

import com.github.l3nnartt.sleep.Sleep;
import com.github.l3nnartt.sleep.utils.SleepUtils;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class PlayerBedEnterListener implements Listener {

  SleepUtils sleepUtils = new SleepUtils();
  Sleep sleep = Sleep.getInstance();

  @EventHandler
  public void playerEnterBed(PlayerBedEnterEvent event) {
    if (event.isCancelled()) return;

    Player player = event.getPlayer();
    World world = event.getPlayer().getWorld();

    sleep.setPlayersSleepNeeded(sleepUtils.calculatePlayersSleepNeeded(event.getPlayer()));
    sleep.setPlayersSleeping(sleep.getPlayersSleeping() + 1);
    world.getPlayers().forEach(p -> p.sendMessage("Sleeping " + sleep.getPlayersSleeping() + "/" + sleep.getPlayersSleepNeeded()));

    if (sleep.getPlayersSleeping() >= sleep.getPlayersSleepNeeded()) {
      event.getPlayer().getWorld().setTime(0);
      world.getPlayers().forEach(p -> p.sendMessage(sleep.getPlayersSleeping() + "/" + sleep.getPlayersSleepNeeded() + "sleeping, skipping to day!"));
    }
  }

  @EventHandler
  public void playerLeaveBed(PlayerBedLeaveEvent event) {
    sleep.setPlayersSleeping(sleep.getPlayersSleeping() - 1);
  }
}
