package ru.restarauntvote.web.dish;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.restarauntvote.model.Dish;
import ru.restarauntvote.repository.dish.DishRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/dishes", produces = MediaType.APPLICATION_JSON_VALUE)
public class DishController {

    private static final Logger log = LoggerFactory.getLogger(DishController.class);

    private final DishRepository dishRepository;

    @Autowired
    public DishController(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @GetMapping(value = "restaurants/{restaurantId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Dish> getAllByRestaurantId(@PathVariable int restaurantId) {
        log.info("getAllByRestaurant dishes, restaurantId -{}", restaurantId);
        return dishRepository.getAllByRestaurantId(restaurantId);
    }

    @GetMapping(value = "/{id}/restaurants/{restaurantId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Dish get(@PathVariable int id, @PathVariable int restaurantId) {
        log.info("get dish id -{}, restaurantId - {}", id, restaurantId);
        return dishRepository.get(id, restaurantId);
    }

    @PostMapping(value = "/restaurants/{restaurantId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void createOrUpdate(@Valid @RequestBody Dish dish, @PathVariable int restaurantId) {
        log.info("createOrUpdate dish, dish - {}, restaurantId - {}", dish, restaurantId);
        dishRepository.save(dish, restaurantId);
    }

    @DeleteMapping(value = "/{id}/restaurants/{restaurantId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id, @PathVariable int restaurantId) {
        log.info("delete dish, id - {}, restaurantId - {} ", id, restaurantId);
        dishRepository.delete(id, restaurantId);
    }
}
