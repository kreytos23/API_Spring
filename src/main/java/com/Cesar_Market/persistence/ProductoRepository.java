package com.Cesar_Market.persistence;

import com.Cesar_Market.domain.Product;
import com.Cesar_Market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Cesar_Market.persistence.crud.ProductoCrudRepository;
import com.Cesar_Market.persistence.entity.Producto;
import com.Cesar_Market.persistence.mapper.ProductMapper;

import java.util.List;
import java.util.Optional;

/*
    Pasos para usar los queryMetods
    1.- Se declara una interfaz del tipo de tabla a la que se le haran las consultas
    2.- Se crean los prototipos de funciones respetando la forma de declararlos y el camelCase
    3.- Importante. usar los nombres especificos de los atributos de la clase a la que se referencian
    4.- crear una clase que servira para declarar y dar formato a las funciones donde se mandara a
        llamar las funciones de la interface a traves de una variable del tipo de la interface
    5.- Se declaran las funciones y se pasara por parametros las columnas a utlizar
    6.- Se retorna mandando a llamar las funciones de la interface con las respectivas tablas
 */

/*
    Para adapatar el Data Mapper junto con la interfaz de Struct Mapper que hace el intercambio de datos
    se implementa la interfaz de los metodos ya con el nombre para el dominio
    Se usa el mapper para pasar de un tipo de dato a otro
 */

/**
 * @Autowired Sirve para que Spring se encargue de crear las instancias de donde utilizaremos los metodos
 *              como el ProductRepository siempre y cuando la clase donde se declara es un componente de spring
 *              como @Repository
 */

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public List<Product> getByCategoryOrderBy(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoria(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProduct(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(prod -> mapper.toProduct(prod));

    }

    @Override
    public Product save(Product product) {
        return mapper.toProduct(productoCrudRepository.save(mapper.toProducto(product)));
    }

    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }
}
