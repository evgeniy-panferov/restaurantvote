package ru.restarauntvote.repository.user;

import ru.restarauntvote.model.User;

import java.util.List;

public interface UserRepository {

    User get(int id);

    User save(User user);

    void delete(int id);

    User getByEmail(String email);

    List<User> getAll();
}
