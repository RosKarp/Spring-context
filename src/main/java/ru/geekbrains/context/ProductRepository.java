package ru.geekbrains.context;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Bread", 10),
                new Product(2L, "Milk", 35),
                new Product(3L, "Apples", 25),
                new Product(4L, "Oranges", 40),
                new Product(5L, "Pears", 45)
        ));
    }
    public List<Product> getProducts() {return products;}
    public Product findById(Long id) throws RuntimeException {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException());
    }
}
