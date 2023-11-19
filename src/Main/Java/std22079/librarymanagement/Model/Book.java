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
    private String topic;
    private BorrowStatus borrowStatus;

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Topic {
        private String id;
        private String topic;
    }
}
