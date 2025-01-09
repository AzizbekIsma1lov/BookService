package uz.java.bookservice.service;

import uz.java.bookservice.domain.dto.requests.BookCreate;
import uz.java.bookservice.domain.dto.response.BookResponse;

import java.util.List;
import java.util.UUID;

public interface BookService {

    BookResponse create(BookCreate bookCreate);
    List<BookResponse> getAllBooks();
    BookResponse searchByTitle(String title);
    List<BookResponse> searchByGenre(String genre);
    List<BookResponse> searchByAuthor(String author);
    List<BookResponse> getBooksById(List<UUID> bookIds);

}
