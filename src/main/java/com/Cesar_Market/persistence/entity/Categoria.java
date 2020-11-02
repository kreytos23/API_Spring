package com.Cesar_Market.persistence.entity;

import javax.persistence.*;
import java.util.List;

/*
 *  @OneToMany  Esta etiqueta se utiloza para asignar en donde esta siendo utilizada su PK
 *              se colaca el MappedBy = colocando el nombre de la variable que tiene asignada
 *              la llave foranea en la tabla que se realizo la relacion
 *              Se coloca la cardinalidad contraria a la tabla donde se creo la llave foranea
 */
@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;
    private String descripcion;
    private String estado;


    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
