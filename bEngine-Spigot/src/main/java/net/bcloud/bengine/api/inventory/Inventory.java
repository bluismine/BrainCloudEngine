package net.bcloud.bengine.api.inventory;

import net.bcloud.bengine.api.color.Colorizer;
import net.bcloud.bengine.api.item.ItemUtil;
import net.bcloud.bengine.bEngine;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

public abstract class Inventory implements InventoryHolder {

    protected final InventoryViewer viewer;
    protected org.bukkit.inventory.Inventory inventory;
    protected String title;
    protected int size;

    public Inventory(InventoryViewer viewer) {
        this.viewer = viewer;
    }

    public abstract void addItems();

    public abstract void handleInventory(InventoryClickEvent e);

    public void onDrag(InventoryDragEvent event) {
        event.setCancelled(true);
    }

    public void open() {
        String title = getTitle();
        if (title == null) title = "Title is null!";
        inventory = Bukkit.createInventory(this, getSize(), Colorizer.apply(title));

        this.addItems();

        viewer.getViewer().openInventory(inventory);
    }

    public void addExit(int slot) {
        inventory.setItem(slot ,ItemUtil.createHead(bEngine.config.getString("inventory-options-item.close.value"), bEngine.config.getString("inventory-options-item.close.name")));
    }

    public void addNextPage(int slot) {
        inventory.setItem(slot ,ItemUtil.createHead(bEngine.config.getString("inventory-options-item.next.value"), bEngine.config.getString("inventory-options-item.next.name")));
    }

    public void addPreviousPage(int slot) {
        inventory.setItem(slot ,ItemUtil.createHead(bEngine.config.getString("inventory-options-item.previous.value"), bEngine.config.getString("inventory-options-item.previous.name")));
    }

    public org.bukkit.inventory.@NotNull Inventory getInventory() {
        return inventory;
    }

    public String getTitle() {
        return title;
    }

    protected void setTitle(String title) {
        this.title = title;
    }

    public int getSize() {
        return size;
    }

    protected void setSize(int size) {
        this.size = size;
    }
}
