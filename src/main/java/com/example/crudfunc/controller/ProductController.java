package com.example.crudfunc.controller;

import java.util.List;

import com.example.crudfunc.model.Product;
import com.example.crudfunc.service.ProductServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductServiceImpl service;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok().body(service.getAllProducts());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id){
        return ResponseEntity.ok().body(service.getProductById(id));
    }

    @GetMapping("/products/name/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable String name){
        return ResponseEntity.ok().body(service.getProductByName(name));
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct (@RequestBody Product product){
        return ResponseEntity.ok().body(service.createProduct(product));
    }

    @PostMapping("/products/many")
    public ResponseEntity<List<Product>> createProducts (@RequestBody List<Product> products){
        return ResponseEntity.ok().body(service.createProducts(products));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable long id){
        product.setId(id);
        return ResponseEntity.ok().body(service.updateProduct(product));
    }

    @DeleteMapping("/products/{id}")
    public HttpStatus deleteProduct(@PathVariable long id){
        service.deleteProduct(id);
        return HttpStatus.OK;
    }
}
