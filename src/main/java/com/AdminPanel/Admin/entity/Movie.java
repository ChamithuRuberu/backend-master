package com.AdminPanel.Admin.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movie")
public class Movie {
    @Id
    @Column(name = "movie_id", length = 10)
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int MovieId;

    @Column(name = "movie_name", length = 20)
    private String MovieName;

    @Column(name = "description", length = 70)
    private String description;

    @Column(name = "releaseDate", length = 20)
    private String releaseDate;

    @Column(name = "Director", length = 20)
    private String Director;

    @Column(name = "movie_duration", length = 20)
    private int duration;

    private String photo;

    @Column(name = "Active_state")
    private boolean activestate;

    @OneToMany(mappedBy="movie_id")
    private Set<BookingDeails> bookingDeails;


    public Movie(String movieName, String description, String releaseDate, String director, int duration, String photo, boolean activestate) {
        MovieName = movieName;
        this.description = description;
        this.releaseDate = releaseDate;
        Director = director;
        this.duration = duration;
        this.photo = photo;
        this.activestate = activestate;
    }
}
