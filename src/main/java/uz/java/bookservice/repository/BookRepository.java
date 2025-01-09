package uz.java.bookservice.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.java.bookservice.domain.entity.BookEntity;
import uz.java.bookservice.domain.entity.enumerators.BookGenre;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, UUID> {
    Optional<BookEntity> searchByTitle(String title);
    List<BookEntity> searchByAuthor(String author);
    List<BookEntity> searchByGenre(BookGenre genre);
    List<BookEntity> findAllByIdIn(List<UUID> booksId);
}
