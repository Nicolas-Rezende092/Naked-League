package recursos;

import java.util.List;

import entidades.Jogador;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("jogador")
public class JogadorRecurso {
    @GET
    public List<Jogador> listar() {
        return Jogador.listAll(Sort.ascending("nome"));
    }

    @POST
    @Transactional
    public void salvar(Jogador jogador) {
        jogador.persist();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void excluir (@PathParam("id") Long id) {
        Jogador jogador = Jogador.findById(id);

        if (jogador != null) {
            jogador.delete();
        } 
    }

    @PUT
    @Path("{id}")
    @Transactional
    public void editar (@PathParam("id") Long id, Jogador jogador) {
        Jogador jogadorExistente = Jogador.findById(id);

        if (jogadorExistente != null) {
            jogadorExistente.nome = jogador.nome;
            jogadorExistente.idade = jogador.idade;
            jogadorExistente.posicao = jogador.posicao;
            jogadorExistente.nacionalidade = jogador.nacionalidade;
            jogadorExistente.email = jogador.email;
            jogadorExistente.instituicao = jogador.instituicao;

            jogadorExistente.persist();
        }
    }


}
