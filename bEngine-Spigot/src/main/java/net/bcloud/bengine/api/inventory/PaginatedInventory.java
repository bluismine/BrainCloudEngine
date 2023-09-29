package net.bcloud.bengine.api.inventory;


public abstract class PaginatedInventory extends Inventory {

    protected int page = 0;
    protected int maxItemsPerPage;

    public PaginatedInventory(InventoryViewer viewer) {
        super(viewer);
    }

    // add some buttons of pages.
    public void addPageManager(boolean useFooter) {
        switch (super.inventory.getSize()) {
            case 36:
                addNextPage(35);
                addPreviousPage(27);
                this.maxItemsPerPage = 27;
            case 45:
                addNextPage(44);
                addPreviousPage(36);
                this.maxItemsPerPage = 36;
            case 54:
                addNextPage(53);
                addPreviousPage(45);
                this.maxItemsPerPage = 45;
            default:
                break;
        }
    }

    public int getMaxItemsPerPage() {
        return maxItemsPerPage;
    }
}
