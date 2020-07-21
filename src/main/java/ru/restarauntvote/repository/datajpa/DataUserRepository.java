package ru.restarauntvote.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.restarauntvote.model.User;

public interface DataUserRepository extends JpaRepository<User, Integer> {

    User save(User user);

}
