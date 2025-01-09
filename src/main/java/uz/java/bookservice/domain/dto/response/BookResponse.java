package uz.java.bookservice.domain.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookResponse extends BaseResponse{
    private String title;
    private String author;
    private String genre;
    private String publisher;
    private Double price;
}
