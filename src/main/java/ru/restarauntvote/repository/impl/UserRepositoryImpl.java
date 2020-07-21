package ru.restarauntvote.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.restarauntvote.model.User;
import ru.restarauntvote.repository.UserRepository;
import ru.restarauntvote.repository.datajpa.DataUserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final DataUserRepository userRepository;

    @Autowired
    public UserRepositoryImpl(DataUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return null;
    }
}
