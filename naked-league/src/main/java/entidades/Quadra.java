package entidades;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Quadra extends PanacheEntityBase {
    
    @Id
    @GeneratedValue (strategy = jakarta.persistence.GenerationType.IDENTITY)
    public Long id;

    public String nome;

    public String localizacao;

    public Integer capacidade;

}
