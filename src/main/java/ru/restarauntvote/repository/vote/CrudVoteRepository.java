package ru.restarauntvote.repository.vote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.restarauntvote.model.Vote;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudVoteRepository extends JpaRepository<Vote, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Vote v WHERE v.id=:id AND v.user.id=:userId")
    int delete(@Param("id") int id, @Param("userId") int userId);

    @Query("SELECT v FROM Vote v WHERE v.user.id=:userId")
    List<Vote> getAllFromUser(@Param("userId") int userId);

    List<Vote> getByRestaurantId(int restaurantId);

    @Query("SELECT v FROM Vote v")
    List<Vote> getAll();

    @Query("SELECT v FROM Vote v WHERE v.id=:id")
    Vote get(@Param("id") int id);
}
