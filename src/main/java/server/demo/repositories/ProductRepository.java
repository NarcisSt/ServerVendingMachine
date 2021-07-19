package server.demo.repositories;

import org.springframework.stereotype.*;
import server.demo.entities.Product;

import javax.persistence.*;
import java.util.*;

@Repository
@Component
public class ProductRepository {
    @PersistenceContext
    EntityManager entityManager;

    public List<Product> getAllProducts() {
        try {
            return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
        } catch (NoResultException noResultException) {
            return new LinkedList<>();
        }
    }

    public List<Product> getProductByName(String name) {
        try {
            return entityManager.createQuery("SELECT p FROM Product p WHERE p.name = :name", Product.class).setParameter("name", name).getResultList();
        } catch (NoResultException noResultException) {
            return new LinkedList<>();
        }
    }

    public Product getProductById(Long id) {
        try {
            return entityManager.createQuery("SELECT p FROM Product p WHERE p.id = :id", Product.class).setParameter("id", id).getSingleResult();
        } catch (NoResultException noResultException) {
            return new Product();
        }
    }

    public Product saveProd(Product product) {
        if(product.getId() == null) {
            entityManager.persist(product);
        } else {
            product = entityManager.merge(product);
        }
        return product;
    }


}
