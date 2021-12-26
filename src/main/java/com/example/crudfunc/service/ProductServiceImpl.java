package com.example.crudfunc.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.crudfunc.exception.ResourceNotFoundException;
import com.example.crudfunc.model.Product;
import com.example.crudfunc.repository.ProductRepostiory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional 
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepostiory repository;

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProductById(long id) {

        Optional<Product> optional = this.repository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }else{
            throw new ResourceNotFoundException("Product not found with id " + id);
        }
    }

    @Override
    public Product getProductByName(String name) {
       return repository.findByName(name);
    }

    @Override
    public Product createProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public List<Product> createProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> optional = this.repository.findById(product.getId());
        
        if(optional.isPresent()){
            Product existingProduct = optional.get();
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrice(product.getPrice());
            repository.save(existingProduct);
            return existingProduct;
        }else{
            throw new ResourceNotFoundException("Record not found with id " + product.getId());
        }

    }

    @Override
    public String deleteProduct(long id) {
        Optional<Product> optional = this.repository.findById(id);
        if(optional.isPresent()){
            repository.delete(optional.get());
            return "user deleted with id " + id;
        }else{
            throw new ResourceNotFoundException("user not found with id " + id);
        }

    }


    
}
