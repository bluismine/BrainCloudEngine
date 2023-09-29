package net.bcloud.bengine.api.inventory;

import net.bcloud.bengine.api.listener.AbstractListener;
import net.bcloud.bengine.bEngine;
import net.bcloud.bengine.bPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class InventoryListener extends AbstractListener<bPlugin> {

    public InventoryListener(@NotNull bPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onInventoryItemClick(InventoryClickEvent event) {
        InventoryHolder holder = event.getInventory().getHolder();

        if (holder instanceof Inventory inv) {
            if (event.getCurrentItem() == null) return;
            if (Objects.requireNonNull(event.getCurrentItem().getItemMeta()).getDisplayName().equalsIgnoreCase(bEngine.config.getString("inventory-options-item.close.name"))) {
                event.getWhoClicked().closeInventory();
            }
            event.setCancelled(true);
            inv.handleInventory(event);
        }
    }

    @EventHandler
    public void onInventoryItemDrag(InventoryDragEvent event) {
        InventoryHolder holder = event.getInventory().getHolder();
        if (holder instanceof Inventory inv) {
            event.setCancelled(true);
//            if (event.getCurrentItem() == null) {
//                return;
//            }
            inv.onDrag(event);
        }
    }
}
