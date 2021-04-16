package com.thushima.BookStore.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PublisherDTO {
    private Integer id;

    @NotNull
    @Size(min = 1, max = 30)
    String name;

    @NotNull
    @Size(min = 4, max = 15)
    String country;

    @NotNull
    @Min(1800)
    @Max(2100)
    Integer year_of_creation;
}
