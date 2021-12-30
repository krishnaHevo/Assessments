package reqres.entities;

import lombok.*;

@Data
@AllArgsConstructor
public
class UserCreationReq {
    private String name;
    private String job;
}
