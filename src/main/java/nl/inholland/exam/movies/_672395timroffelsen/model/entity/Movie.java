package nl.inholland.exam.movies._672395timroffelsen.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"movie\"")
public class Movie
{
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToMany(mappedBy = "movie")
    @JsonIgnoreProperties("movie")
    private List<Review> reviews = new ArrayList<>();
    private int yearOfRelease;

    public Movie(String name, int yearOfRelease)
    {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
    }

    @Transient
    private double averageScore;
}
