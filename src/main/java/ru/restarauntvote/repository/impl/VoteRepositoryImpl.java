package ru.restarauntvote.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.restarauntvote.model.Vote;
import ru.restarauntvote.repository.VoteRepository;
import ru.restarauntvote.repository.datajpa.DataRestaurantRepository;
import ru.restarauntvote.repository.datajpa.DataUserRepository;
import ru.restarauntvote.repository.datajpa.DataVoteRepository;

import java.util.List;

@Repository
public class VoteRepositoryImpl implements VoteRepository {

    private final DataVoteRepository voteRepository;
    private final DataRestaurantRepository restaurantRepository;
    private final DataUserRepository userRepository;

    @Autowired
    public VoteRepositoryImpl(DataVoteRepository voteRepository, DataRestaurantRepository restaurantRepository,
                              DataUserRepository userRepository) {
        this.voteRepository = voteRepository;
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Vote save(Vote vote, int restaurantId, int userId) {
        return null;
    }

    @Override
    public List<Vote> getByRestaurant() {
        return null;
    }
}
