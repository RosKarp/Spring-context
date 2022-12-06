package ru.geekbrains.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component("prototype")
public class Cart {
    private List<Product> inCart = new ArrayList<>();
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public void addAll() { inCart.addAll(productRepository.getProducts());}

    public void addProductById(Long id) throws RuntimeException {
        inCart.add(productRepository.findById(id));
    }
    public void deleteProductById(Long id) throws RuntimeException {
        inCart.remove(productRepository.findById(id));
    }
    public void showCart() {
            for (Product product:
                 inCart) {
                System.out.println(product.toString());
            }
    }
}
