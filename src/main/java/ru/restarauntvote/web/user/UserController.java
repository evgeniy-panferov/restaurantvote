package ru.restarauntvote.web.user;

import com.fasterxml.jackson.annotation.JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.restarauntvote.model.User;
import ru.restarauntvote.service.UserService;
import ru.restarauntvote.util.SecurityUtil;
import ru.restarauntvote.util.View;

import javax.validation.Valid;
import java.util.List;

import static ru.restarauntvote.util.UserUtil.createUserWithRoleNotAdmin;
import static ru.restarauntvote.util.ValidationUtil.assureIdConsistent;
import static ru.restarauntvote.util.ValidationUtil.checkNew;


@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @JsonView(View.UserRest.class)
    @GetMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        log.info("get all user");
        return userService.getAll();
    }

    @JsonView(View.UserRest.class)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User get() {
        int userId = SecurityUtil.authUserId();
        log.info("get user, id - {}", userId);
        return userService.get(userId);
    }

    @JsonView(View.UserRest.class)
    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@Valid @RequestBody User user) {
        log.info("create user - {}", user);
        checkNew(user);
        userService.save(createUserWithRoleNotAdmin(user));
    }

    @JsonView(View.UserRest.class)
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody User user) {
        int userId = SecurityUtil.authUserId();
        log.info("update user - {}, userId - {}", user, userId);
        assureIdConsistent(user, userId);
        userService.save(user);
    }

    @JsonView(View.UserRest.class)
    @DeleteMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete() {
        int userId = SecurityUtil.authUserId();
        log.info("delete user, id - {}", userId);
        userService.delete(userId);
    }
}
