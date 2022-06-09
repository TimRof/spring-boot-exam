package nl.inholland.exam.movies._672395timroffelsen.configuration;

import nl.inholland.exam.movies._672395timroffelsen.model.entity.Movie;
import nl.inholland.exam.movies._672395timroffelsen.model.entity.Review;
import nl.inholland.exam.movies._672395timroffelsen.repository.MovieRepository;
import nl.inholland.exam.movies._672395timroffelsen.repository.ReviewRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class MyApplicationRunner implements ApplicationRunner
{
    MovieRepository movieRepository;
    ReviewRepository reviewRepository;

    public MyApplicationRunner(ReviewRepository reviewRepository, MovieRepository movieRepository)
    {
        this.movieRepository = movieRepository;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        Movie movie1 = new Movie("48 hours", 1982);
        Movie movie2 = new Movie("Once Upon a Time in the West", 1968);

        movie1 = movieRepository.save(movie1);
        movie2 = movieRepository.save(movie2);

        Review review1 = new Review("Mark", LocalDate.of(2022, 6, 7), movie1, 5, "Interesting documentary about life in the 1980s");
        Review review2 = new Review("Wim", LocalDate.of(2022, 6, 7), movie1, 2, "I did not like this movie at all");
        Review review3 = new Review("Wim", LocalDate.of(2022, 6, 7), movie2, 5, "The true classic among spaghetti westerns.");

        reviewRepository.saveAll(List.of(review1, review2, review3));
    }
}
