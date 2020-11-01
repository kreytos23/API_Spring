package persistence.entity;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

/*
    @Entity         se indica que la clase de va a comportar como una tabla SQL
    @Table          Con esta anotacion se indica que la clase será la tabla y se le incluye
                    la definicion del nombre de la tabla
    @Id             Esta hace referencia a que ese atributo sera nuestra PK
    @GeneratedValue Hace la funcion de un Identity para autoincrementar la PK
    @Column         Define ese atributo como una columna de la tabla y solo es necesaria
                    si el nombre del atributo no corresponde con el nombre de la columna
                    en la base de datos

    Esta es una clase que se referenciara a la tabla Compra en la base de datos
 */
@Entity
@Table(name = "compras")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer idCompra;
    @Column(name = "id_cliente")
    private String idCliente;
    private LocalDateTime fecha;
    @Column(name = "medio_pago")
    private String medioDePago;
    private String comentario;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id",insertable = false ,updatable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "producto")
    private List<ComprasProductos> comprasProductos;

    public List<ComprasProductos> getComprasProductos() {
        return comprasProductos;
    }

    public void setComprasProductos(List<ComprasProductos> comprasProductos) {
        this.comprasProductos = comprasProductos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(String medioDePago) {
        this.medioDePago = medioDePago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
