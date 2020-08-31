package ru.restarauntvote.repository.vote;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.restarauntvote.model.Restaurant;
import ru.restarauntvote.model.User;
import ru.restarauntvote.model.Vote;
import ru.restarauntvote.repository.restaurant.CrudRestaurantRepository;
import ru.restarauntvote.repository.user.CrudUserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class VoteRepositoryImpl implements VoteRepository {

    private final CrudVoteRepository crudVoteRepository;
    private final CrudRestaurantRepository crudRestaurantRepository;
    private final CrudUserRepository crudUserRepository;

    public VoteRepositoryImpl(CrudVoteRepository crudVoteRepository, CrudRestaurantRepository crudRestaurantRepository,
                              CrudUserRepository crudUserRepository) {
        this.crudVoteRepository = crudVoteRepository;
        this.crudRestaurantRepository = crudRestaurantRepository;
        this.crudUserRepository = crudUserRepository;
    }

    @Override
    public List<Vote> getAllFromUser(int userId) {
        return crudVoteRepository.getAllFromUser(userId);
    }
    @Override
    public List<Vote> getAll() {
        return crudVoteRepository.getAll();
    }

    @Override
    public Vote save(Vote vote,int restaurantId) {
        User user = crudUserRepository.findById(vote.getUser().getId()).orElse(null);
        Restaurant restaurant = crudRestaurantRepository.findById(restaurantId).orElse(null);
        vote.setDate(LocalDateTime.now());
        vote.setRestaurantId(restaurant.getId());
        vote.setUser(user);
        user.setLastTimeVote(LocalDateTime.now());
        crudUserRepository.save(user);
        return crudVoteRepository.save(vote);
    }

    @Override
    @Transactional
    public void delete(int id, int userId) {
        crudVoteRepository.delete(id, userId);
    }

    @Override
    public List<Vote> getByRestaurantId(int restaurantId) {
        return crudVoteRepository.getByRestaurantId(restaurantId);
    }
}
