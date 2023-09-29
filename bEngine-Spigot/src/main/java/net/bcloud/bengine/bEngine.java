package net.bcloud.bengine;


import net.bcloud.bengine.api.command.CoreCommand;
import net.bcloud.bengine.api.inventory.InventoryListener;
import net.bcloud.bengine.api.logger.Logger;
import net.bcloud.bengine.command.bEngineCommand;
import net.bcloud.bengine.file.SetupFile;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class bEngine extends bPlugin<bEngine> {

    public static YamlConfiguration config;
    private static bEngine instance;

    public static bEngine getInstance() {
        return instance;
    }

    private InventoryListener inventoryListener;

    @Override
    public void enable() {
        instance = this;
        int pluginId = 19736;
        String bukkitVersion = Bukkit.getVersion();
        if (bukkitVersion.contains("1.8") &&
                bukkitVersion.contains("1.9") &&
                bukkitVersion.contains("1.10") &&
                bukkitVersion.contains("1.11") &&
                bukkitVersion.contains("1.12") &&
                bukkitVersion.contains("1.13") &&
                bukkitVersion.contains("1.14") &&
                bukkitVersion.contains("1.15") &&
                bukkitVersion.contains("1.16") &&
                bukkitVersion.contains("1.17")) {
            getLogger().warning("================================================================");
            getLogger().warning("This plugin only support Bukkit/CraftBukkit server 1.18.X and upper!");
            getLogger().warning("================================================================");
            this.getServer().getPluginManager().disablePlugin(this);
        }
        // Create main folder
        File folder = new File("plugins\\", this.getDescription().getName());
        if (!folder.exists()) folder.mkdir();
        new SetupFile();
        registerHook();
        registerCommand();
        this.inventoryListener = new InventoryListener(this);
        this.inventoryListener.registerListeners();
    }

    @Override
    public void disable() {
        if (this.inventoryListener != null) {
            this.inventoryListener.unregisterListeners();
            this.inventoryListener = null;
        }
    }

    @Override
    public void registerCommand() {
        Logger.sendInfoLog("Starting register command...");
        CoreCommand.registerCommand(bEngine.getPlugin(bEngine.class).getDataFolder().getName(), new bEngineCommand("bengine"));
    }

    @Override
    public boolean registerHook() {
        Logger logger = new Logger(this);
        return true;
    }


}
