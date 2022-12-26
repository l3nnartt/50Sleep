package com.github.l3nnartt.sleep;

import org.bukkit.plugin.java.JavaPlugin;

public final class Sleep extends JavaPlugin {

  private int playersSleepNeeded;
  private int playersSleeping;

  @Override
  public void onEnable() {
    // Plugin startup logic

  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }

  public int getPlayersSleepNeeded() {
    return playersSleepNeeded;
  }

  public void setPlayersSleepNeeded(int playersSleepNeeded) {
    this.playersSleepNeeded = playersSleepNeeded;
  }

  public int getPlayersSleeping() {
    return playersSleeping;
  }

  public void setPlayersSleeping(int playersSleeping) {
    this.playersSleeping = playersSleeping;
  }

  public static Sleep getInstance() {
    return getPlugin(Sleep.class);
  }

}
