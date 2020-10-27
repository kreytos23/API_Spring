package persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    private Integer idCliente;
}
