package entidades;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Olheiro extends PanacheEntityBase{

    @Id
    @GeneratedValue (strategy = jakarta.persistence.GenerationType.IDENTITY)
    public Long Id;

    public String nome;

    public String nacionalidade;

    public Integer instituicao;

    public String email;
    
}
