package com.thushima.BookStore.service;

import com.thushima.BookStore.dto.PublisherDTO;
import com.thushima.BookStore.entity.Publisher;
import com.thushima.BookStore.exception.PublisherAlreadyExistsException;
import com.thushima.BookStore.mapper.PublisherMapper;
import com.thushima.BookStore.repository.PublisherRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
public class PublisherServiceTest {

    private static final Long INVALID_PUBLISHER_ID = 2L;

    @Mock
    PublisherRepository publisherRepository;

    @InjectMocks
    private PublisherService publisherService;

    private final PublisherMapper publisherMapper = PublisherMapper.INSTANCE;

    @Test
    void whenPublisherInformedItShouldBeCreated() throws PublisherAlreadyExistsException {

        // given
        PublisherDTO publisherDTO = PublisherDTO.builder().build();
        Publisher expectedPublisher = publisherMapper.toModel(publisherDTO);

        // when
        when(publisherRepository.findByName(expectedPublisher.getName())).thenReturn(Optional.empty());
        when(publisherRepository.save(expectedPublisher)).thenReturn(expectedPublisher);

        // then
        PublisherDTO createdPublisherDTO = publisherService.createPublisher(publisherDTO);

        assertThat(createdPublisherDTO.getId(), is(expectedPublisher.getId()));
        assertThat(createdPublisherDTO.getName(), is(expectedPublisher.getName()));
        assertThat(createdPublisherDTO.getCountry(), is(expectedPublisher.getCountry()));
        assertThat(createdPublisherDTO.getYear_of_creation(), is(expectedPublisher.getYear_of_creation()));

    }


}
