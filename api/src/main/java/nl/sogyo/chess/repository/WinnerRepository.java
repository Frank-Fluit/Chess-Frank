package nl.sogyo.chess.repository;

import nl.sogyo.chess.entity.Winner;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WinnerRepository extends CrudRepository<Winner, Long> {

    @Query("SELECT w.name, COUNT(w.name) AS games_won " +
            "FROM Winner w " +
            "GROUP BY w.name " +
            "ORDER BY games_won DESC")
    List<Object[]> countWinners();
}