package com.nesGS.movies.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    @Size(max = 100, message = "Title must not exceed 100 characters")
    private String title;

    @Min(value = 1888, message = "Release year must be no earlier than 1888") // First year of film creation
    @Max(value = 2100, message = "Release year is too far in the future")
    private int releaseYear;

    @Min(value = 0, message = "Votes must be a non-negative number")
    private int votes;

    @DecimalMin(value = "0.0", message = "Rating must be a positive number")
    @DecimalMax(value = "10.0", message = "Rating must not exceed 10.0")
    private double rating;

    @URL(message = "Image URL must be valid")
    private String imageUrl;

}
