package reqres.entities;
import lombok.*;

@Data
@AllArgsConstructor
class ClassData
{
    private Integer id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}

@Data
@AllArgsConstructor
class Support
{
    private String url;
    private String text;
}

@Data
@AllArgsConstructor
public class User {
    private ClassData data;
    private Support support;
}

