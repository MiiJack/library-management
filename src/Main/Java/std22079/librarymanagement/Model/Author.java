package std22079.librarymanagement.Model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Author extends User {
    private String sex;
    public Author(int id, String name, String sex) {
        super(id, name);
        this.sex = sex;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + sex;
    }
}
