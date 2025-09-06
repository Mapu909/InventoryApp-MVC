package org.selflearning.global_superstore.models;

import java.util.Date;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;
import org.selflearning.global_superstore.validation.annotations.ValidPrice;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

@ValidPrice(message = "Items Price should be greater than discount.")
public class Item {

    // Fields
    private String id;

    @NotBlank(message = "Items category must not be blank.")
    private String category;

    @NotBlank(message = "Items name must not be blank.")
    @Length(min = 3, max = 50, message = "Items name should have 3 - 50 characters.")
    private String name;

    @Positive(message = "Items price must be positive.")
    private double price;

    @Positive(message = "Items discount must be positive.")
    @Max(value = 50, message = "Items discount should be less than 50.")
    @Min(value = 0, message = "Items discount should be greater than or equals 0.")
    private double discount;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Items order date should be in the past.")
    private Date date;

    // Constructors
    public Item() {
        id = UUID.randomUUID().toString();
    }

    // Setters and Getters
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return this.discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;

        if (!(other instanceof Item))
            return false;

        Item item = (Item) other;
        return item.getId().equals(this.getId());
    }

}
