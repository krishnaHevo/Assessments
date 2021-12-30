package reqres.entities;

import lombok.*;

@Data
@AllArgsConstructor
public class UserCreationResponse {
    private String name;
    private String job;
    private String id;
    private String createdAt;
}

