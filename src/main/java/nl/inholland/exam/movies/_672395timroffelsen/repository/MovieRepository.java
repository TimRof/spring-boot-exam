package nl.inholland.exam.movies._672395timroffelsen.repository;

import nl.inholland.exam.movies._672395timroffelsen.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>
{
    Movie findMovieByNameIgnoreCaseAndYearOfRelease(String name, int yearOfRelease);
}

