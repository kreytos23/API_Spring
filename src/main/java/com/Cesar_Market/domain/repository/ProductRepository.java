package com.Cesar_Market.domain.repository;

import com.Cesar_Market.domain.Product;
import org.apache.catalina.LifecycleState;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    List<Product> getByCategoryOrderBy(int categoryId);
    Optional<List<Product>> getByCategory(int categoryId );
    Optional<List<Product>> getScarseProduct(int quantity);
    Optional<Product> getProduct(int productId);
    Product save (Product product);
    void delete(int productId);
}
