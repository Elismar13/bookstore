package com.thushima.BookStore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends Exception {

    public BookNotFoundException(String bookTitle) {
        super(String.format("Publisher with title %s not found.", bookTitle));
    }

}