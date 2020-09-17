package ru.restarauntvote.web.vote;

import com.fasterxml.jackson.annotation.JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.restarauntvote.model.Vote;
import ru.restarauntvote.repository.vote.VoteRepository;
import ru.restarauntvote.util.SecurityUtil;
import ru.restarauntvote.util.View;

import javax.validation.Valid;
import java.util.List;

import static ru.restarauntvote.util.ValidationUtil.checkNew;
import static ru.restarauntvote.util.ValidationUtil.checkNotFoundWithId;

@RestController
@RequestMapping(value = "/restaurants")
public class VoteController {

    private static final Logger log = LoggerFactory.getLogger(VoteController.class);

    private final VoteRepository voteRepository;

    @Autowired
    public VoteController(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @GetMapping(value = "/votes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vote> getAll() {
        log.info("getAll");
        return voteRepository.getAll();
    }

    @GetMapping(value = "/users/votes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vote> getAllFromUser() {
        int userId = SecurityUtil.authUserId();
        log.info("getAllFromUser, userId - {}", userId);
        return voteRepository.getAllFromUser(userId);
    }

    @GetMapping(value = "/{restaurantId}/votes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vote> getAllFromRestaurant(@PathVariable int restaurantId) {
        log.info("getAllFromRestaurant restaurantId - {}", restaurantId);
        return checkNotFoundWithId(voteRepository.getByRestaurantId(restaurantId), restaurantId);
    }

    @JsonView(View.VoteRest.class)
    @PostMapping(value = "/{restaurantId}/votes")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@Valid @RequestBody Vote vote, @PathVariable int restaurantId) {
        log.info("create vote, vote - {}, restaurantId - {}", vote, restaurantId);
        checkNew(vote);
        voteRepository.save(vote, restaurantId);
    }

    @JsonView(View.VoteRest.class)
    @PutMapping(value = "/{restaurantId}/votes")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody Vote vote, @PathVariable int restaurantId) {
        log.info("update vote, vote - {}, restaurantId - {}", vote, restaurantId);
        checkNotFoundWithId(voteRepository.save(vote, restaurantId), vote.getId());
    }

    @DeleteMapping("/votes/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        int userId = SecurityUtil.authUserId();
        log.info("delete vote, id - {}, userId - {}", id, userId);
        checkNotFoundWithId(voteRepository.delete(id, userId), id);
    }
}
