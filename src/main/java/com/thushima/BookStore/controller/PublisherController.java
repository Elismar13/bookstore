package com.thushima.BookStore.controller;

import com.thushima.BookStore.dto.PublisherDTO;
import com.thushima.BookStore.exception.PublisherAlreadyExistsException;
import com.thushima.BookStore.service.PublisherService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/publishers")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PublisherController {

    private final PublisherService publisherService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PublisherDTO createPublisher(@RequestBody @Valid PublisherDTO publisherDTO) throws PublisherAlreadyExistsException {
        return publisherService.createPublisher(publisherDTO);
    }

}
