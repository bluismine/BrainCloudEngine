package net.bcloud.bengine;

import net.bcloud.bengine.api.logger.Logger;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public abstract class bPlugin<P extends bPlugin<P>>  extends JavaPlugin {

    public abstract void enable();

    public abstract void disable();

    public abstract void registerCommand();

    public abstract boolean registerHook();

    @Override
    public void onEnable() {
        long loadTook = System.currentTimeMillis();

        this.loadManagers();

        String ping;
        final long pings = System.currentTimeMillis() - loadTook;
        if (pings < 100) ping = "&a" + pings + "&r";
        else if (pings < 250) ping = "&e" + pings + "&r";
        else ping = "&c" + pings + "&r";
        Logger.sendInfoLog("Plugin loaded in " + ping + " ms!");
    }

    @Override
    public void onDisable() {
        this.unloadManagers();
        this.getServer().getServicesManager().unregisterAll(this);
        Bukkit.getScheduler().cancelTasks(this);
        Logger.sendInfoLog(String.format("&aDisabled Version %s%n", getDescription().getVersion()));
    }

    protected void loadManagers() {
        Logger logger = new Logger(this);
        this.enable();
    }

    private void unloadManagers() {
        this.getServer().getScheduler().cancelTasks(this); // First stop all plugin tasks

        this.disable();

        // Unregister ALL plugin listeners.
        this.unregisterListeners();
    }

    private void unregisterListeners() {
        HandlerList.unregisterAll(this);
    }

    public void runTask(@NotNull Consumer<BukkitTask> consumer) {
        this.getServer().getScheduler().runTask(this, consumer);

    }

    public void runTaskAsync(@NotNull Consumer<BukkitTask> consumer) {
        this.getServer().getScheduler().runTaskAsynchronously(this, consumer);
    }

    public void runTaskLater(@NotNull Consumer<BukkitTask> consumer, long delay) {
        this.getServer().getScheduler().runTaskLater(this, consumer, delay);
    }
}
