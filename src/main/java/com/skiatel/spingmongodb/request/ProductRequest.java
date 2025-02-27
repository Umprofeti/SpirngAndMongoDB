package com.skiatel.spingmongodb.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductRequest {

    @Size(min=1, message = "El nombre del producto es requerido")
    @NotNull(message = "El nombre del producto es requerido")
    private String name;

    @NotNull(message = "La descripción del producto es requerida")
    @Size(min=10, message = "La descripción del producto es requerida")
    private String description;

    @NotNull(message = "El precio del producto es requerido")
    private double price;

    @NotNull(message = "La cantidad del producto es requerida")
    private int quantity;

    @NotNull(message = "La categoría del producto es requerida")
    @Size(min=1, message = "La categoría del producto es requerida")
    private String category;

    public ProductRequest() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
