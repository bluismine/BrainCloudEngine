package net.bcloud.bengine.api.inventory;

import net.bcloud.bengine.bEngine;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryConfirm extends Inventory {


    public InventoryConfirm(InventoryViewer viewer) {
        super(viewer);
        setTitle(bEngine.config.getString("menu.confirm.name"));
        setSize(27);
        addExit(22);
    }

    @Override
    public void addItems() {}

    @Override
    public void handleInventory(InventoryClickEvent e) {
    }

}
