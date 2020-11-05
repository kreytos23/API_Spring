package com.Cesar_Market.domain.repository;

import com.Cesar_Market.domain.Product;
import org.apache.catalina.LifecycleState;

import java.util.List;
import java.util.Optional;

/*
    En esta interface se declaran los mismos metodos a ejecutar en el producto
    se hace para implementar de Data Mapper y asi lograr que nuestro programa no sea dependiente de una base de datos
    en especifico
    Se usa el Product ademas para formalizar la API al idioma ingles
 */

public interface ProductRepository {
    List<Product> getAll();
    List<Product> getByCategoryOrderBy(int categoryId);
    Optional<List<Product>> getByCategory(int categoryId );
    Optional<List<Product>> getScarseProduct(int quantity);
    Optional<Product> getProduct(int productId);
    Product save (Product product);
    void delete(int productId);
}
