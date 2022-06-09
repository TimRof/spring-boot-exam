package nl.inholland.exam.movies._672395timroffelsen.repository;

import nl.inholland.exam.movies._672395timroffelsen.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>
{
}
