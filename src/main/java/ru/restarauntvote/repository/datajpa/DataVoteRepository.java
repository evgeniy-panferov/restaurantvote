package ru.restarauntvote.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.restarauntvote.model.Vote;

import java.util.List;

public interface DataVoteRepository extends JpaRepository<Vote, Integer> {

    Vote save(Vote vote, int restaurantId,int userId);

    List<Vote> getByRestaurant();

}
