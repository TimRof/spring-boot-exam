package nl.inholland.exam.movies._672395timroffelsen.model.dto.review;

import com.fasterxml.jackson.annotation.JsonProperty;
import nl.inholland.exam.movies._672395timroffelsen.model.dto.DTOEntity;

import java.time.LocalDate;
import java.util.Date;

public class reviewDTO implements DTOEntity
{
    @JsonProperty("movieId")
    private long id;

    @JsonProperty("author")
    private String writtenBy;

    private LocalDate writtenAt;

    private String content;

    private int score;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getWrittenBy()
    {
        return writtenBy;
    }

    public void setWrittenBy(String writtenBy)
    {
        this.writtenBy = writtenBy;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }


}
