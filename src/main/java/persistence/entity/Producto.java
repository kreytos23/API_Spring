package persistence.entity;

import javax.persistence.*;

/*
    @Entity         se indica que la clase de va a comportar como una tabla SQL
    @Table          Con esta anotacion se indica que la clase será la tabla y se le incluye
                    la definicion del nombre de la tabla
    @Id             Esta hace referencia a que ese atributo sera nuestra PK
    @GeneratedValue Hace la funcion de un Identity para autoincrementar la PK
    @Column         Define ese atributo como una columna de la tabla y solo es necesaria
                    si el nombre del atributo no corresponde con el nombre de la columna
                    en la base de datos

    @ManyToOne      Define que la relacion de la FK será en relacion uno a muchos,
                    siguiendo las reglas de niveles de abtraccion de las entidades en
                    SQL
    @JoinColumn     Define a que columna se le relacionara (la PK de la tabla que
                    se le relaciona, ademas de agregar las anotaciones para que no sea posible
                    editar o modificar la tabla que se le relaciona desde la tabla que
    Esta es una clase que se referenciara a la tabla Compra en la base de datos
 */
@Entity
@Table(name = "productos")

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    
    private Integer idProducto;
    private String nombre;
    @Column(name = "id_categoria")
    private Integer idCategoria;
    @Column(name ="codigo_barras")
    private String codigoBarras;
    @Column(name = "precio_venta")
    private Double precioVenta;
    @Column(name = "cantidad_stock")
    private Integer cantidadStock;
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false,updatable = false)
    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
