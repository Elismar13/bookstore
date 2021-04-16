package com.thushima.BookStore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BookAlreadyExistsException extends Exception {

    public BookAlreadyExistsException(String bookTitle) {
        super(String.format("Publisher with name %s already exists.", bookTitle));
    }

}