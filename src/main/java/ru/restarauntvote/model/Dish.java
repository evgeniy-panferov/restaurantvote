package ru.restarauntvote.model;

import javax.persistence.*;

@Entity
@Table(name = "dishes")
public class Dish extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    Restaurant restaurant;

    @Column(name = "price", nullable = false)
    int price;

    @Column(name = "description", nullable = false)
    private String description;


    public Dish(int id, String description) {
        super(id);
        this.description = description;
    }

    public Dish() {
    }

}
