package uz.java.bookservice.domain.dto.requests;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookCreate {
    private String title;
    private String author;
    private String genre;
    private String publisher;
    private Double price;
}
