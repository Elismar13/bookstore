package com.thushima.BookStore.mapper;

import com.thushima.BookStore.dto.PublisherDTO;
import com.thushima.BookStore.entity.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);

    Publisher toModel(PublisherDTO beerDTO);

    PublisherDTO toDTO(Publisher beer);
}