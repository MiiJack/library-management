package std22079.librarymanagement.Model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Subscriber extends User {
    private String reference;
}
