package ru.restarauntvote.repository;

import ru.restarauntvote.model.User;

public interface UserRepository {
    User save(User user);
}
