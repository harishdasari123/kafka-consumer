package org.harish.consumer.customdeserializer;

public class Order {
    private String customer;
    private String product;
    private int quantity;

    public Order() {
    }

    public Order(String customer, String product, int i) {
        this.customer = customer;
        this.product = product;
        this.quantity = i;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
