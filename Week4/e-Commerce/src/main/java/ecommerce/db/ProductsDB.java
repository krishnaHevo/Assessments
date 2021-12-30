package ecommerce.db;

import ecommerce.representations.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductsDB {
    private final ArrayList<Product> products = new ArrayList<>();

    public ProductsDB() {
        products.add(new Product(1, "Wildcraft Laptop Bag", "2000", "Bags"));
        products.add(new Product(2, "Louis Philippe Blue Shirt", "2000", "Shirts"));
        products.add(new Product(3, "OnePlus 6", "40000", "Mobiles"));
        products.add(new Product(4, "MacBook Pro", "164000", "Laptops"));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductByID(Integer id) {
        for(Product product : products)
            if (Objects.equals(product.getId(), id))
                return product;
        return null;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(Integer id, Product product) {
        removeProduct(id);
        products.add(product);
    }

    public boolean removeProduct(int id) {
        for(Product i : products) {
            if (Objects.equals(i.getId(), id)) {
                products.remove(i);
                return true;
            }
        }
        return false;
    }
}
