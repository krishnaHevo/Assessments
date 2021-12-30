package ecommerce.representations;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Product {

    private Integer id;
    private String name;
    private String price;
    private String category;

    public Product(Integer id) {
        // Jackson deserialization
    }

    @JsonProperty
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty
    public void setPrice(String price) {
        this.price = price;
    }

    @JsonProperty
    public void setType(String type) {
        this.category = type;
    }

    @JsonProperty
    public Integer getId() {
        return id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public String getPrice() {
        return price;
    }

    @JsonProperty
    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product [id="+id+", name="+name+", price="+price+", category="+category+"]";
    }
}
