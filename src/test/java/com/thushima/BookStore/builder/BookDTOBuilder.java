package com.thushima.BookStore.builder;

import com.thushima.BookStore.dto.BookDTO;
import lombok.Builder;

@Builder
public class BookDTOBuilder {

    @Builder.Default
    private final Integer id = 1;

    @Builder.Default
    String title = "Gamers: The next level";

    @Builder.Default
    String description = "A book for gamers! Available now.";

    @Builder.Default
    String author = "Thushima";

    @Builder.Default
    Integer pages = 89;

    @Builder.Default
    Integer publisher_id = 1;

    public BookDTO toBookDTO() {
        return new BookDTO(id,
                title,
                description,
                author,
                pages,
                publisher_id
        );
    }
}
