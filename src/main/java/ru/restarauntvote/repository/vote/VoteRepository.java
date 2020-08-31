package ru.restarauntvote.repository.vote;

import ru.restarauntvote.model.Vote;

import java.util.List;

public interface VoteRepository {

    List<Vote> getAllFromUser(int userId);

    Vote save(Vote vote, int restaurantId);

    void delete(int id, int userId);

    List<Vote> getByRestaurantId(int restaurantId);

    List<Vote> getAll();
}
