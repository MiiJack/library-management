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

    @Override
    public String toString() {
        return super.toString() + ", ref: " + reference;
    }
}
