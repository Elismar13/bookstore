package com.thushima.BookStore.service;

import com.thushima.BookStore.dto.PublisherDTO;
import com.thushima.BookStore.entity.Publisher;
import com.thushima.BookStore.exception.PublisherAlreadyExistsException;
import com.thushima.BookStore.mapper.PublisherMapper;
import com.thushima.BookStore.repository.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper = PublisherMapper.INSTANCE;

    public PublisherDTO createPublisher(PublisherDTO publisherDTO) throws PublisherAlreadyExistsException {
        verifyIfIsAlreadyRegistered(publisherDTO.getName());
        Publisher publisher = publisherMapper.toModel(publisherDTO);
        Publisher savedPublisher = publisherRepository.save(publisher);
        return publisherMapper.toDTO(savedPublisher);
    }

    private void verifyIfIsAlreadyRegistered(String name) throws PublisherAlreadyExistsException {
        Optional<Publisher> optSavedPublisher = publisherRepository.findByName(name);
        if(optSavedPublisher.isPresent()) {
            throw new PublisherAlreadyExistsException(name);
        }
    }

}
