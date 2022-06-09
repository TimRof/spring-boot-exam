package nl.inholland.exam.movies._672395timroffelsen.controller;

import nl.inholland.exam.movies._672395timroffelsen.model.dto.review.reviewDTO;
import nl.inholland.exam.movies._672395timroffelsen.model.entity.Review;
import nl.inholland.exam.movies._672395timroffelsen.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/reviews")
public class ReviewController
{
    ReviewService reviewService;

    public ReviewController(ReviewService reviewService)
    {
        this.reviewService = reviewService;
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity<Review> createOne(@RequestBody reviewDTO reviewDTO)
    {
        return new ResponseEntity<Review>(this.reviewService.addOne(reviewDTO), HttpStatus.CREATED);
    }
}
