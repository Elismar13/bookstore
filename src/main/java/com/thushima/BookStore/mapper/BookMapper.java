package com.thushima.BookStore.mapper;

import com.thushima.BookStore.dto.BookDTO;
import com.thushima.BookStore.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book toModel(BookDTO beerDTO);

    BookDTO toDTO(Book beer);
}