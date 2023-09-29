package net.bcloud.bengine.api.inventory;

import org.bukkit.entity.Player;

public class InventoryViewer {

    private final Player viewer;

    public InventoryViewer(Player viewer) {
        this.viewer = viewer;
    }

    public Player getViewer() {
        return viewer;
    }
}
