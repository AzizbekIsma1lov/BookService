package uz.java.bookservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.java.bookservice.domain.dto.requests.BookCreate;
import uz.java.bookservice.domain.dto.response.BookResponse;
import uz.java.bookservice.domain.entity.BookEntity;
import uz.java.bookservice.domain.entity.enumerators.BookGenre;
import uz.java.bookservice.repository.BookRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    @Override
    public BookResponse create(BookCreate bookCreate) {
        BookEntity bookEntity = createBookEntity(bookCreate);
        return createBookResponse(bookEntity);
    }

    @Override
    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll().stream().map(BookServiceImpl::createBookResponse).collect(Collectors.toList());
    }

    @Override
    public BookResponse searchByTitle(String title) {
        BookEntity bookEntity = bookRepository.searchByTitle(title).orElseThrow(() -> new RuntimeException("Book not found"));
        return createBookResponse(bookEntity);
    }

    @Override
    public List<BookResponse> searchByGenre(String genre) {
        return bookRepository.searchByGenre(BookGenre.valueOf(genre))
                .stream().map(BookServiceImpl::createBookResponse).collect(Collectors.toList());
    }

    @Override
    public List<BookResponse> searchByAuthor(String author) {
        return bookRepository.searchByAuthor(author)
                .stream()
                .map(BookServiceImpl::createBookResponse).collect(Collectors.toList());
    }
    @Override
    public List<BookResponse> getBooksById(List<UUID> bookIds) {
        return List.of();
    }
    private BookEntity createBookEntity(BookCreate bookCreate) {
        BookEntity bookEntity = BookEntity.builder()
                .title(bookCreate.getTitle())
                .author(bookCreate.getAuthor())
                .genre(BookGenre.valueOf(bookCreate.getGenre()))
                .publisher(bookCreate.getPublisher())
                .price(bookCreate.getPrice())
                .build();
        bookRepository.save(bookEntity);
        return bookEntity;
    }
    private static BookResponse createBookResponse(BookEntity bookEntity) {
        BookResponse bookResponse = BookResponse.builder()
                .title(bookEntity.getTitle())
                .author(bookEntity.getAuthor())
                .genre(String.valueOf(bookEntity.getGenre()))
                .publisher(bookEntity.getPublisher())
                .price(bookEntity.getPrice())
                .build();
        bookResponse.setId(bookEntity.getId());
        bookResponse.setCreatedAt(bookEntity.getCreatedAt());
        bookResponse.setUpdatedAt(bookEntity.getUpdatedAt());
        return bookResponse;
    }
}
