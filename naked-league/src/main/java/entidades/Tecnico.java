package entidades;

import java.util.Date;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Tecnico extends PanacheEntityBase {
    
    @Id
    @GeneratedValue (strategy = jakarta.persistence.GenerationType.IDENTITY)
    public Long Id;

    public String nome;

    public String nacionalidade;

    public Date dataNascimento;

    public String timeAtual;

    public Integer titulos;

    public Date dataInicio;

}
