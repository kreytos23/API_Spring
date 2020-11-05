package com.Cesar_Market.persistence.mapper;

import com.Cesar_Market.domain.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.Cesar_Market.persistence.entity.Producto;

import java.util.List;

/*
    En esta clase se usa el mapper que ayudara a facilitar el cambio de una clase a otra, poniendo como sourse el
    atributo de donde se tomaran los datos, en este caso el de la base de datos, y como target se usan los atributso de
    nuestra clase que se usara en nuestra API
 */

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category")
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras",ignore = true)
    Producto toProducto(Product product);
    List<Producto>toProductos(List<Product> products);
}
