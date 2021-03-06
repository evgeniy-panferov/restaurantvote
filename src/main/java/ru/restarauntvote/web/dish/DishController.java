package ru.restarauntvote.web.dish;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.restarauntvote.model.Dish;
import ru.restarauntvote.repository.dish.DishRepository;

import javax.validation.Valid;
import java.util.List;

import static ru.restarauntvote.util.ValidationUtil.checkNew;
import static ru.restarauntvote.util.ValidationUtil.checkNotFoundWithId;

@RestController
@RequestMapping(value = "/restaurants", produces = MediaType.APPLICATION_JSON_VALUE)
public class DishController {

    private static final Logger log = LoggerFactory.getLogger(DishController.class);

    private final DishRepository dishRepository;

    @Autowired
    public DishController(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Cacheable(value = "dishes")
    @GetMapping(value = "{restaurantId}/dishes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Dish> getAllByRestaurantId(@PathVariable int restaurantId) {
        log.info("getAllByRestaurant dishes, restaurantId -{}", restaurantId);
        return checkNotFoundWithId(dishRepository.getAllByRestaurantId(restaurantId), restaurantId);
    }

    @GetMapping(value = "/{restaurantId}/dishes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Dish get(@PathVariable int id, @PathVariable int restaurantId) {
        log.info("get dish id -{}, restaurantId - {}", id, restaurantId);
        return checkNotFoundWithId(dishRepository.get(id, restaurantId), id);
    }

    @CacheEvict(value = {"restaurants", "dishes"}, allEntries = true)
    @PostMapping(value = "/{restaurantId}/dishes")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@Valid @RequestBody Dish dish, @PathVariable int restaurantId) {
        log.info("create dish, dish - {}, restaurantId - {}", dish, restaurantId);
        checkNew(dish);
        dishRepository.save(dish, restaurantId);
    }

    @CacheEvict(value = {"restaurants", "dishes"}, allEntries = true)
    @PutMapping(value = "/{restaurantId}/dishes")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody Dish dish, @PathVariable int restaurantId) {
        log.info("update dish, dish - {}, restaurantId - {}", dish, restaurantId);
        checkNotFoundWithId(dishRepository.save(dish, restaurantId), dish.getId());
    }

    @CacheEvict(value = {"restaurants", "dishes"}, allEntries = true)
    @DeleteMapping(value = "/{restaurantId}/dishes/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id, @PathVariable int restaurantId) {
        log.info("delete dish, id - {}, restaurantId - {} ", id, restaurantId);
        checkNotFoundWithId(dishRepository.delete(id, restaurantId), id);
    }
}
