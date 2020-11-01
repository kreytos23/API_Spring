package persistence;

import org.springframework.stereotype.Repository;
import persistence.crud.ProductoCrudRepository;
import persistence.entity.Producto;

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

@Repository
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoria(idCategoria);
    }

    public List<Producto>getByCategoriaOrderByNombre(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getLessCantidadStock(int cantidadStock,boolean estado){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidadStock,estado);
    }

    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
