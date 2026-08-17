public class Order {
    String id;
    String item;
    double amount;
    String country;
    String userId;

    public Order(String id, String item, double amount, String country, String userId) {
        this.id = id;
        this.item = item;
        this.amount = amount;
        this.country = country;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public double getAmount() {
        return amount;
    }

    public String getCountry() {
        return country;
    }

    public String getUserId() {
        return userId;
    }
}
