package recursos;

import java.util.List;

import entidades.Olheiro;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("olheiro")
public class OlheiroRecurso {
    @GET
    public List<Olheiro> listar() {
        return Olheiro.listAll(Sort.ascending("nome"));
    }

    @POST
    @Transactional
    public void salvar(Olheiro olheiro) {
        olheiro.persist();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void excluir (@PathParam("id") Long id) {
        Olheiro olheiro = Olheiro.findById(id);

        if (olheiro != null) {
            olheiro.delete();
        } 
    }

    @PUT
    @Path("{id}")
    @Transactional
    public void editar (@PathParam("id") Long id, Olheiro olheiro) {
        Olheiro olheiroExistente = Olheiro.findById(id);

        if (olheiroExistente != null) {
            olheiroExistente.nome = olheiro.nome;
            olheiroExistente.nacionalidade = olheiro.nacionalidade;
            olheiroExistente.instituicao = olheiro.instituicao;
            olheiroExistente.email = olheiro.email;

            olheiroExistente.persist();
        }
    }
}
