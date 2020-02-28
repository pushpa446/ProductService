package com.vodqa.productservice.web.models;

public class Product {

    private Integer id;
    private String name;
    private float price;

    protected Product() {
    }

    public Product(Integer id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format(
                "Product[id=%d, name='%s', price='%s']",
                id, name, price);
    }
}
