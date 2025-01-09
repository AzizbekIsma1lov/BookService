package uz.java.bookservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.java.bookservice.domain.dto.requests.BookCreate;
import uz.java.bookservice.domain.dto.response.BookResponse;
import uz.java.bookservice.service.BookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    @PostMapping("/create-book")
    public BookResponse create(@RequestBody BookCreate bookCreate){
        return bookService.create(bookCreate);
    }

    @GetMapping("/get-all")
    public List<BookResponse> getAll(){
        return bookService.getAllBooks();
    }

    @GetMapping("/search-by-title")
    public BookResponse searchByTitle(@RequestParam("title") String title){
        return bookService.searchByTitle(title);
    }

    @GetMapping("/search-by-author")
    public List<BookResponse> searchByAuthor(@RequestParam("author") String author){
        return bookService.searchByAuthor(author);
    }

    @GetMapping("/search-by-genre")
    public List<BookResponse> searchByGenre(@RequestParam("genre") String genre){
        return bookService.searchByGenre(genre);
    }

}
