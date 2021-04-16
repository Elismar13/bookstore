package com.thushima.BookStore.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Integer id;

    @NotNull
    @Size(min = 1, max = 30)
    String title;

    @NotNull
    @Size(min = 1, max = 100)
    String description;

    @NotNull
    @Size(min = 4, max = 25)
    String author;

    @NotNull
    @Range(min = 10, max=2000)
    Integer pages;

    @NotNull
    Integer publisher_id;
}
