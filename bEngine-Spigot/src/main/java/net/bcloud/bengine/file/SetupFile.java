package net.bcloud.bengine.file;

import net.bcloud.bengine.api.logger.Logger;
import net.bcloud.bengine.bEngine;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SetupFile {

    public SetupFile() {
        List<String> files = new ArrayList<>();
        files.add("config.yml");

        for (String file : files) {
            if (!new File(bEngine.getInstance().getDataFolder(), file).exists()) {
                bEngine.getInstance().saveResource(file, false);
                Logger.sendInfoLog("Created " + file);
            }
        }

        bEngine.config = YamlConfiguration.loadConfiguration(new File(bEngine.getInstance().getDataFolder(), "config.yml"));
    }
}
