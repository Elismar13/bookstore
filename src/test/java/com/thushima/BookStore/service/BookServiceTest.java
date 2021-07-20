package com.thushima.BookStore.service;

import com.thushima.BookStore.builder.BookDTOBuilder;
import com.thushima.BookStore.dto.BookDTO;
import com.thushima.BookStore.entity.Book;
import com.thushima.BookStore.exception.BookAlreadyExistsException;
import com.thushima.BookStore.exception.BookNotFoundException;
import com.thushima.BookStore.mapper.BookMapper;
import com.thushima.BookStore.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    private static final long INVALID_BOOK_ID = 1L;

    @Mock
    private BookRepository bookRepository;

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @InjectMocks
    private BookService bookService;

    @Test
    void whenBookInformedThenItShouldBeCreated() throws BookAlreadyExistsException {
        // given
        BookDTO expectedBookDTO = BookDTOBuilder.builder().build().toBookDTO();
        Book expectedSavedBook = bookMapper.toModel(expectedBookDTO);

        // when
        when(bookRepository.findByTitle(expectedBookDTO.getTitle())).thenReturn(Optional.empty());
        when(bookRepository.save(expectedSavedBook)).thenReturn(expectedSavedBook);

        // then
        BookDTO createdBookDTO = bookService.createBook(expectedBookDTO);

        assertThat(createdBookDTO.getId(), is(equalTo(expectedBookDTO.getId())));
        assertThat(createdBookDTO.getTitle(), is(equalTo(expectedBookDTO.getTitle())));
        assertThat(createdBookDTO.getDescription(), is(equalTo(expectedBookDTO.getDescription())));
        assertThat(createdBookDTO.getAuthor(), is(equalTo(expectedBookDTO.getAuthor())));
        assertThat(createdBookDTO.getPages(), is(equalTo(expectedBookDTO.getPages())));
        assertThat(createdBookDTO.getPublisher_id(), is(equalTo(expectedBookDTO.getPublisher_id())));
    }

    @Test
    void whenAlreadyRegisteredBookInformedThenAnExceptionShouldBeThrown() {
        // given
        BookDTO expectedBookDTO = BookDTOBuilder.builder().build().toBookDTO();
        Book duplicatedBook = bookMapper.toModel(expectedBookDTO);

        // when
        when(bookRepository.findByTitle(expectedBookDTO.getTitle())).thenReturn(Optional.of(duplicatedBook));

        // then
        assertThrows(BookAlreadyExistsException.class, () -> bookService.createBook(expectedBookDTO));
    }

    @Test
    void whenValidBookNameIsGivenThenReturnABook() throws BookNotFoundException {
        // given
        BookDTO expectedBookDTO = BookDTOBuilder.builder().build().toBookDTO();
        Book expectedFoundBook = bookMapper.toModel(expectedBookDTO);

        // when
        when(bookRepository.findByTitle(expectedFoundBook.getTitle())).thenReturn(Optional.of(expectedFoundBook));

        // then
        BookDTO foundBookDTO = bookService.findByTitle(expectedBookDTO.getTitle());

        assertThat(expectedBookDTO, is(equalTo(foundBookDTO)));
    }
}
