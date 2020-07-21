package ru.restarauntvote.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "dishes")
public class Dish extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant restaurant;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "description", nullable = false)
    @NotBlank
    private String description;

    @Column(name = "date")
    @NotNull
    private LocalDateTime date;

    public Dish(Restaurant restaurant, int price, String description, LocalDateTime date) {
        this.restaurant = restaurant;
        this.price = price;
        this.description = description;
        this.date = date;
    }

    public Dish() {
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
