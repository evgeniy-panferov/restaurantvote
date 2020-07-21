package ru.restarauntvote.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractEntity {

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @OneToMany
    private List<Dish> menu;

    public Restaurant(int id, String name) {
        super(id);
        this.name = name;
    }
    public Restaurant(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getMenu() {
        return menu;
    }

    public void setMenu(List<Dish> menu) {
        this.menu = menu;
    }
}
