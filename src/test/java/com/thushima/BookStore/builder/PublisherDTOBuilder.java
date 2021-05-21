package com.thushima.BookStore.builder;

import com.sun.istack.NotNull;
import com.thushima.BookStore.dto.PublisherDTO;
import lombok.Builder;

import javax.validation.constraints.Size;

@Builder
public class PublisherDTOBuilder {

    @Builder.Default
    Integer id = 1;

    @Builder.Default
    String name = "Thushima";

    @Builder.Default
    String country = "Brasil";

    @Builder.Default
    Integer year_of_creation = 2021;

    public PublisherDTO toPublisherDTO() {
        return new PublisherDTO(id,
                name,
                country,
                year_of_creation
        );
    }
}
