package com.thushima.BookStore.controller;

import com.thushima.BookStore.dto.BookDTO;
import com.thushima.BookStore.exception.BookAlreadyExistsException;
import com.thushima.BookStore.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/books")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookController {

    private final BookService bookService;

    @PostMapping
    public BookDTO createBook(@RequestBody @Valid BookDTO bookDTO) throws BookAlreadyExistsException {
        return bookService.createBook(bookDTO);
    }

}
