package net.bcloud.bengine.api.inventory.item;

import net.bcloud.bengine.api.inventory.InventoryViewer;
import org.bukkit.event.inventory.InventoryClickEvent;

public interface ItemClick {
    void click(InventoryViewer viewer, InventoryClickEvent event);
}
