package std22079.librarymanagement.Model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BorrowStatus {
    private String id;
    private boolean isAvailable;
    private Subscriber borrowedBy;
    private LocalDateTime lastBorrowDate;
}
