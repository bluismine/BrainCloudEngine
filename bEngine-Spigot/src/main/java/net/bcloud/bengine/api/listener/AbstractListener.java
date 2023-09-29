package net.bcloud.bengine.api.listener;

import net.bcloud.bengine.bPlugin;
import org.jetbrains.annotations.NotNull;

public class AbstractListener<P extends bPlugin> implements EventListener {

    @NotNull
    public final P plugin;

    public AbstractListener(@NotNull P plugin) {
        this.plugin = plugin;
    }

    @Override
    public void registerListeners() {
        plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
    }
}
