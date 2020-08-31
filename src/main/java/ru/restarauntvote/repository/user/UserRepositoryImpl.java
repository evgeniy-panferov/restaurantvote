package ru.restarauntvote.repository.user;

import org.springframework.stereotype.Repository;
import ru.restarauntvote.model.User;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final CrudUserRepository crudUserRepository;

    public UserRepositoryImpl(CrudUserRepository crudUserRepository) {
        this.crudUserRepository = crudUserRepository;
    }

    @Override
    public User get(int id) {
        return crudUserRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return crudUserRepository.save(user);
    }

    @Override
    public void delete(int id) {
        crudUserRepository.deleteById(id);
    }

    @Override
    public User getByEmail(String email) {
        return crudUserRepository.getByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return crudUserRepository.findAll();
    }
}
