package nl.inholland.exam.movies._672395timroffelsen.controller;

import nl.inholland.exam.movies._672395timroffelsen.model.entity.Movie;
import nl.inholland.exam.movies._672395timroffelsen.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/movies")
public class MovieController
{
    private MovieService movieService;

    public MovieController(MovieService movieService)
    {
        this.movieService = movieService;
    }

    @GetMapping
    public @ResponseBody
    ResponseEntity<List<Movie>> getAll()
    {
        return new ResponseEntity<List<Movie>>(this.movieService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    ResponseEntity<Movie> getById(@PathVariable long id)
    {
        return new ResponseEntity<Movie>(this.movieService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity<Movie> createOne(@RequestBody Movie movie)
    {
        return new ResponseEntity<Movie>(this.movieService.addOne(movie), HttpStatus.CREATED);
    }
}
