package com.Cesar_Market.web.controller;

import com.Cesar_Market.domain.Product;
import com.Cesar_Market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/category/{id}")
    public Optional<List<Product>> getByCategory(@PathVariable("id") int categoryId){
        return productService.getByCategoria(categoryId);
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") int productId){
        return productService.getProduct(productId);
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int productId){
        return productService.delete(productId);
    }
}
