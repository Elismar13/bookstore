package com.thushima.BookStore.service;

import com.thushima.BookStore.dto.BookDTO;
import com.thushima.BookStore.entity.Book;
import com.thushima.BookStore.exception.BookAlreadyExistsException;
import com.thushima.BookStore.mapper.BookMapper;
import com.thushima.BookStore.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookService {

    private final BookRepository bookRepository;

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    public BookDTO createBook(BookDTO bookDTO) throws BookAlreadyExistsException {
        verifyIfIsAlreadyRegistered(bookDTO.getTitle());
        Book book = bookMapper.toModel(bookDTO);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toDTO(savedBook);
    }

    private void verifyIfIsAlreadyRegistered(String title) throws BookAlreadyExistsException {
        Optional<Book> optSavedBook = bookRepository.findByTitle(title);
        if(optSavedBook.isPresent()) {
            throw new BookAlreadyExistsException(title);
        }
    }

}
