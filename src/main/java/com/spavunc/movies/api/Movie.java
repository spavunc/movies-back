package com.spavunc.movies.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name="release_date")
    private LocalDate date;
    @Column(name="rating")
    private Double rank;
    private BigDecimal revenue;

    Movie(String title, LocalDate releaseDate, Double rating, BigDecimal revenue){
        this.title = title;
        this.date = releaseDate;
        this.rank = rating;
        this.revenue = revenue;
    }

}
