package reqres.entities;

import lombok.*;

@Data
@AllArgsConstructor
public class Register {
    private String email;
    private String password;
}

