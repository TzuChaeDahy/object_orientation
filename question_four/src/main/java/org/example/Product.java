package org.example;

import java.util.List;

public class Product {
    private Integer code;
    private String name;
    private Double price;
    private Integer quantity;

    public Product(String name, Double price, Integer quantity, List<Product> products) throws Exception {
        Integer code = (int) Math.floor(Math.random() * 1000);
        while (!isNumberPossible(code, products)) {
            code = (int) Math.floor(Math.random() * 1000);
        }
        this.code = code;

        if (name == null || name.isEmpty()) {
            throw new Exception("Nome inválido!");
        }
        this.name = name;

        if (price <= 0 ) {
            throw new Exception("Preço inválido!");
        }
        this.price = price;

        if (quantity < 0) {
            throw new Exception("Quantidade inválido!");
        }
        this.quantity = quantity;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void sellProduct(Integer selledQuantity) {
        this.quantity -= selledQuantity;
    }

    private Boolean isNumberPossible(Integer code, List<Product> products) {
        for (Product product : products) {
            if (product.getCode().equals(code)) {
                return false;
            }
        }

        return true;
    }
}
