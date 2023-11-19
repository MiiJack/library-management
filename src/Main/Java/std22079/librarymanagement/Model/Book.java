package std22079.librarymanagement.Model;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Book {
    private int id;
    private String name;
    private int pageNumbers;
    private LocalDate releaseDate;
    private Author author;
    private Topic topic;
    private BorrowStatus borrowStatus;

}
