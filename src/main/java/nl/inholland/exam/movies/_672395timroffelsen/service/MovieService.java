package nl.inholland.exam.movies._672395timroffelsen.service;

import nl.inholland.exam.movies._672395timroffelsen.exception.ResourceNotFoundException;
import nl.inholland.exam.movies._672395timroffelsen.model.entity.Movie;
import nl.inholland.exam.movies._672395timroffelsen.repository.MovieRepository;
import nl.inholland.exam.movies._672395timroffelsen.utils.DtoUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class MovieService
{
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository)
    {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAll()
    {
        List<Movie> movies = movieRepository.findAll();
        Integer scores = 0;
        movies.forEach(movie ->
        {
            movie.setAverageScore(getAverageScore(movie).get());
        });

        return movies;
    }

    private Movie checkForDuplicate(String name, int yearOfRelease)
    {
        Movie movie = this.movieRepository.findMovieByNameIgnoreCaseAndYearOfRelease(name, yearOfRelease);
        return movie;
    }

    private AtomicReference<Double> getAverageScore(Movie movie)
    {
        AtomicReference<Double> average = new AtomicReference<>((double) 0);
        AtomicReference<Double> finalScores = new AtomicReference<>((double) 0);
        movie.getReviews().stream().forEach(review ->
        {
            finalScores.updateAndGet(v -> v + review.getScore());
            average.set(finalScores.get() / movie.getReviews().size());
        });
        return average;
    }

    public Movie getById(long id)
    {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie with id: '" + id + "' not found."));
        movie.setAverageScore(getAverageScore(movie).get());
        return movie;
    }

    public Movie addOne(Movie movie)
    {
        Movie movieCheck = checkForDuplicate(movie.getName(), movie.getYearOfRelease());
        if (movieCheck == null)
        {
            return this.movieRepository.save(movie);
        } else
        {
            return movieCheck;
        }
    }

}
