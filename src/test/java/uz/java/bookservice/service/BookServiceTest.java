package uz.java.bookservice.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import uz.java.bookservice.domain.dto.response.BookResponse;
import uz.java.bookservice.domain.entity.BookEntity;
import uz.java.bookservice.repository.BookRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static uz.java.bookservice.domain.entity.enumerators.BookGenre.ROMANCE;

public class BookServiceTest {


    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;


    @Test
    void bookCreateTest() {
        when(bookRepository.save(createBookEntity())).thenReturn(createBookEntity());
        when(createBookResponse(createBookEntity())).thenReturn(createBookResponse());

        BookEntity save = bookRepository.save(createBookEntity());
        BookEntity bookEntity = createBookEntity();

        assertEquals(save.getTitle(), bookEntity.getTitle());
    }


    @Test
    void  searchBookByTitleTest() {
       when(bookRepository.searchByTitle(any(String.class))).thenReturn(Optional.of(createBookEntity()));

        BookResponse bookResponse = bookService.searchByTitle("username");
        assertNotNull(bookResponse);
    }












    private BookEntity createBookEntity() {
        BookEntity bookEntity = new BookEntity(
                "O'tgan kunlar",
                "Abdulla Qodiriy",
                ROMANCE,
                "Aziz",
                45.0);
        return bookEntity;
    }

    private BookResponse createBookResponse() {
        BookResponse bookResponse = new BookResponse(
                "O'tgan kunlar",
                "Abdulla Qodiriy",
                "ROMANCE",
                "Aziz",
                45.0);
        return bookResponse;
    }

    private BookResponse createBookResponse(BookEntity bookEntity) {
        BookResponse bookResponse = new BookResponse(
                bookEntity.getTitle(),
                bookEntity.getAuthor(),
                String.valueOf(bookEntity.getGenre()),
                bookEntity.getPublisher(),
                bookEntity.getPrice());
        return bookResponse;
    }

}


