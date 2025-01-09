package uz.java.bookservice.domain.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import uz.java.bookservice.domain.entity.enumerators.BookGenre;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "books")
@Builder

public class BookEntity extends BaseEntity{
    private String title;
    private String author;
    @Enumerated(EnumType.STRING)
    private BookGenre genre;
    private String publisher;
    private Double price;

}
