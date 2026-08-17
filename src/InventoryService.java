public class InventoryService implements OrderListener {

    @Override
    public void onOrderPlaced(Order order) {
        System.out.println("[Inventory] Reserving stock for Order#1001: Laptop ($999.00)");
    }
}
