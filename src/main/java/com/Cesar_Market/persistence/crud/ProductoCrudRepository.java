package com.Cesar_Market.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import com.Cesar_Market.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

/*
    En esta interface se utiliza el CrudRepository para heredar las funciones de querys que
    facilicita los querys, se realiza la interface y dentro de esta se dclaran los protottipos
    de las funciones que se declararan
 */
/*
        Para usar querysMethots de SpringData se deben seguir ciertas reglas para declarar
        el nombre del metodo a usarse, siguiendo el CamelCase
     */

/*
    Esta anotacion de query se usa si no se quiere usar QueryMethots se puede declarar y
    escribirse de forma ordinaria en SQL, siempre declarando que es un query nativo, una vez declarado
    se le puede asignar el nombre cualquiera al metodo
 */
public interface ProductoCrudRepository extends CrudRepository<Producto,Integer> {

    //@Query(value = "SELECT * FROM Producto WHERE id_categoria = ?",nativeQuery = true)

    List<Producto> findByIdCategoria(int idCategoria);

    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}


