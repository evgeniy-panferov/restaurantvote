package ru.restarauntvote.repository;

import ru.restarauntvote.model.Vote;

import java.util.List;

public interface VoteRepository {

    Vote save(Vote vote, int restaurantId, int userId);

    List<Vote> getByRestaurant();
}
