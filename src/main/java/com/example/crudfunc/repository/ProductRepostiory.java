package com.example.crudfunc.repository;

import com.example.crudfunc.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepostiory extends JpaRepository<Product, Long>{

    Product findByName(String name);

}