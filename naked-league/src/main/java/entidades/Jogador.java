package entidades;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "jogador")
public class Jogador extends PanacheEntityBase {

    public String nome;

    public Integer idade;

    public String posicao;

    public String nacionalidade;

    public String email;

    public Integer instituicao;

}