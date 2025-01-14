package uz.java.bookservice;

import uz.java.bookservice.domain.dto.requests.BookCreate;
import uz.java.bookservice.domain.entity.BookEntity;

import static uz.java.bookservice.domain.entity.enumerators.BookGenre.ROMANCE;

public class TestBase {

    protected BookCreate bookCreate = new BookCreate(
            "O'tgan kunlar",
            "Abdulla Qodiriy",
            "ROMANCE",
            "Aziz",
            45.0);


    protected final BookEntity bookEntity = new BookEntity(
            "O'tgan kunlar",
            "Abdulla Qodiriy",
            ROMANCE,
            "Aziz",
            45.0);

}
