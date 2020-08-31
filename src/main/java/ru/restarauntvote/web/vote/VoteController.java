package ru.restarauntvote.web.vote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.restarauntvote.model.Vote;
import ru.restarauntvote.repository.vote.VoteRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/votes")
public class VoteController {

    private static final Logger log = LoggerFactory.getLogger(VoteController.class);

    private final VoteRepository voteRepository;

    @Autowired
    public VoteController(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vote> getAll() {
        log.info("getAll");
        return voteRepository.getAll();
    }

    @GetMapping(value = "/users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vote> getAllFromUser(@PathVariable int userId) {
        log.info("getAllFromUser, userId - {}", userId);
        return voteRepository.getAllFromUser(userId);
    }

    @GetMapping(value = "/restaurants/{restaurantId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vote> getAllFromRestaurant(@PathVariable int restaurantId) {
        log.info("getAllFromRestaurant restaurantId - {}", restaurantId);
        return voteRepository.getByRestaurantId(restaurantId);
    }

    @PostMapping(value = "/restaurants/{restaurantId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void createOrUpdate(@Valid @RequestBody Vote vote, @PathVariable int restaurantId) {
        log.info("create vote, vote - {}, restaurantId - {}", vote, restaurantId);
        voteRepository.save(vote, restaurantId);
    }

    @DeleteMapping("/{id}/users/{userId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id, @PathVariable int userId) {
        log.info("delete vote, id - {}, userId - {}", id, userId);
        voteRepository.delete(id, userId);
    }
}
