package std22079.librarymanagement.Model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BorrowStatus {
    private String id;
    private boolean isAvailable;
    private Visitor borrowedBy;
    private LocalDateTime lastBorrowDate;
}
