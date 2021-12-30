package reqres.entities;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
public class UserList {
    private Integer page;
    private Integer per_page;
    private Integer total;
    private Integer total_pages;
    private List<ClassData> data;
    private Support support;
}
