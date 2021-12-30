package reqres.entities;

import lombok.*;

@Data
@AllArgsConstructor
public class UserUpdationResponse {
    private String name;
    private String job;
    private String updatedAt;
}
