package std22079.librarymanagement.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic {
    private String id;
    private String topic;

    @Override
    public String toString() {
        return topic;
    }
}

