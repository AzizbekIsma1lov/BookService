package uz.java.bookservice.repository;

import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import uz.java.bookservice.TestBase;
import uz.java.bookservice.domain.entity.BookEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static uz.java.bookservice.domain.entity.enumerators.BookGenre.ROMANCE;

@DataJpaTest
public class BookRepositoryTest extends TestBase {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void testSave() {
        BookEntity bookEntity = bookRepository.save(createBookEntity());
      BookEntity bookEntity1 = new BookEntity();
        assertNotNull(bookEntity.getId());

        bookEntity1.setTitle(bookEntity.getTitle());
        assertThrows(DataIntegrityViolationException.class,
                () -> bookRepository.save(bookEntity1));

    }

    @Test
    void testSaveUniqueException(){
        bookRepository.save(createBookEntity());

        BookEntity bookEntity1 = new BookEntity();
        bookEntity1.setTitle(bookEntity.getTitle());
        assertThrows(DataIntegrityViolationException.class, () -> bookRepository.save(bookEntity1));
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


}
