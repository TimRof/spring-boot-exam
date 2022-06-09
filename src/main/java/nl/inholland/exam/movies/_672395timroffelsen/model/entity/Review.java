package nl.inholland.exam.movies._672395timroffelsen.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"review\"")
public class Review
{
    @Id
    @GeneratedValue
    private long id;
    private String writtenBy;
    private LocalDate writtenAt;

    @ManyToOne
    @JsonIgnoreProperties("movie")
    private Movie movie;

    private int score;
    private String content;

    public Review(String writtenBy, LocalDate writtenAt, Movie movie, int score, String content)
    {
        this.writtenBy = writtenBy;
        this.writtenAt = writtenAt;
        this.movie = movie;
        this.score = score;
        this.content = content;
    }
}
