package server.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.demo.entities.Product;
import server.demo.services.ServiceProduct;

import java.rmi.ServerException;
import java.util.*;

@RestController
@RequestMapping(value = "/home")
public class ProductController {
    private final ServiceProduct serviceProduct;

    @Autowired
    public ProductController(ServiceProduct serviceProduct) {
        this.serviceProduct = serviceProduct;
    }

    @GetMapping(value = "/msg")
    public ResponseEntity<String> printWelcomeMessage() {
        return new ResponseEntity<>(serviceProduct.displayMessage(), HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Product>> getAllP() {
        return new ResponseEntity<>(serviceProduct.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<List<Product>> getPByName(@PathVariable String name) {
        return new ResponseEntity<>(serviceProduct.getByName(name), HttpStatus.OK);
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Product> getPById(@PathVariable Long id) {
        return new ResponseEntity<>(serviceProduct.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<Product> saveP(@RequestBody Product product) {
        return new ResponseEntity<>(ServiceProduct.saveProduct(product), HttpStatus.CREATED);
    }
}
