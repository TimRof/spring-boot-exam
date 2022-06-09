package nl.inholland.exam.movies._672395timroffelsen.service;

import nl.inholland.exam.movies._672395timroffelsen.model.dto.review.reviewDTO;
import nl.inholland.exam.movies._672395timroffelsen.model.entity.Movie;
import nl.inholland.exam.movies._672395timroffelsen.model.entity.Review;
import nl.inholland.exam.movies._672395timroffelsen.repository.ReviewRepository;
import nl.inholland.exam.movies._672395timroffelsen.utils.DtoUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReviewService
{
    private final MovieService movieService;
    private final ReviewRepository reviewRepository;
    private final DtoUtils dtoUtils;

    public ReviewService(MovieService movieService, ReviewRepository reviewRepository, DtoUtils dtoUtils)
    {
        this.movieService = movieService;
        this.reviewRepository = reviewRepository;
        this.dtoUtils = dtoUtils;
    }

    public List<Review> getAll()
    {
        return this.reviewRepository.findAll();
    }

    public Review addOne(reviewDTO reviewDTO)
    {
        Movie movie = this.movieService.getById(reviewDTO.getId());
        Review review = (Review) this.dtoUtils.convertToEntity(new Review(), reviewDTO);
        review.setMovie(movie);
        review.setWrittenAt(LocalDate.now());

        return this.reviewRepository.save(review);
    }
}
