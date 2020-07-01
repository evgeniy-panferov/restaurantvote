package ru.restarauntvote.model;

import javax.persistence.*;

@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    protected AbstractEntity(int id) {
        this.id = id;
    }

    protected AbstractEntity() {

    }

}
