package com.example.crudfunc.service;

import java.util.List;

import com.example.crudfunc.model.Product;

public interface ProductService {
    
    List<Product> getAllProducts();
    Product getProductById(long id);
    Product getProductByName(String name);
    Product createProduct(Product product);
    List<Product> createProducts(List<Product> products);
    Product updateProduct(Product product);
    String deleteProduct(long id);

}
