package com.spavunc.movies.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class MovieCommand {
    @NotBlank(message = "Title must not be empty")
    private String title;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy.")
    private LocalDate date;
    @Max(message = "Rating cannot be higher than 10", value = 10)
    @PositiveOrZero(message = "Rating cannot be lower than 0")
    private Double rank;
    private BigDecimal revenue;
}
