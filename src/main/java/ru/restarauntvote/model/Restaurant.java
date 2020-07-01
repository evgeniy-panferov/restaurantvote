package ru.restarauntvote.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractEntity {

    private int rating;

    private String name;

    private List<Dish> menu;

    public Restaurant(int id, String name) {
        super(id);
        this.name = name;
    }
    public Restaurant(){

    }

    public int getRating() {
        return rating;
    }

    public void setRating(int vote) {
        this.rating = vote;
    }
}
