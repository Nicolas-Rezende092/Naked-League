package entidades;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Jogador extends PanacheEntityBase {

    @Id
    @GeneratedValue (strategy = jakarta.persistence.GenerationType.IDENTITY)
    public Integer id;
    
    public String nome;

    public Integer idade;

    public String posicao;

    public String nacionalidade;

    public String email;

    public Integer instituicao;

}