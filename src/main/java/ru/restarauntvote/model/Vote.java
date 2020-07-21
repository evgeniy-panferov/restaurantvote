package ru.restarauntvote.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "Votes")
public class Vote extends AbstractEntity {

    @Column(name = "date")
    @NotNull
    private LocalDateTime date;

    public Vote() {
    }

    public Vote(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
