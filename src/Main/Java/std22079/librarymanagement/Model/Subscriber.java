package std22079.librarymanagement.Model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Subscriber extends User {
    private String reference;

    public Subscriber(int id, String name, String reference) {
        super(id, name);
        this.reference = reference;
    }
}
