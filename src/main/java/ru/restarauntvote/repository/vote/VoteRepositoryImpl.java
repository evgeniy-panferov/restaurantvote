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

import static ru.restarauntvote.util.ValidationUtil.checkNotFound;

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
    public Vote get(int id) {
        return crudVoteRepository.get(id);
    }

    @Override
    public Vote save(Vote vote, int restaurantId) {
        Restaurant restaurant = crudRestaurantRepository.findById(restaurantId).orElse(null);
        User user = crudUserRepository.findById(vote.getUser().getId()).orElse(null);
        if (!vote.isNew() && get(vote.getId()) == null) {
            return null;
        }
        checkNotFound(restaurant, String.format("Restaurant with id : %s not found", restaurantId));
        checkNotFound(user, String.format("User with id : %s not found", vote.getUser().getId()));

        vote.setDate(LocalDateTime.now());
        vote.setRestaurantId(restaurant.getId());
        vote.setUser(user);
        user.setLastTimeVote(LocalDateTime.now());
        crudUserRepository.save(user);
        return crudVoteRepository.save(vote);
    }

    @Override
    @Transactional
    public boolean delete(int id, int userId) {
        return crudVoteRepository.delete(id, userId) != 0;
    }

    @Override
    public List<Vote> getByRestaurantId(int restaurantId) {
        List<Vote> byRestaurantId = crudVoteRepository.getByRestaurantId(restaurantId);
        return byRestaurantId.size() == 0 ? null : byRestaurantId;
    }
}
