package server.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import server.demo.entities.Product;
import server.demo.repositories.ProductRepository;

import java.util.*;

@Service
@Component
public class ServiceProduct {
    private final ProductRepository repository;

    @Autowired
    public ServiceProduct(ProductRepository repository) {
        this.repository = repository;
    }

    public String displayMessage() {
        return "Welcome!!";
    }

    public List<Product> getAll() {
        return this.repository.getAllProducts();
    }

    public List<Product> getByName(String name) {
        return this.repository.getProductByName(name);
    }

    public Product getById(Long id) {
        return this.repository.getProductById(id);
    }

    public Product saveProduct(Product product) {
        return this.repository.saveProd(product);
    }
}
