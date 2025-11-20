package recursos;

import java.util.List;

import entidades.Tecnico;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("tecnico")
public class TecnicoRecurso {
    @GET
    public List<Tecnico> listar() {
        return Tecnico.listAll(Sort.ascending("nome"));
    }

    @POST
    @Transactional
    public void salvar(Tecnico tecnico) {
        tecnico.persist();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void excluir (@PathParam("id") Long id) {
        Tecnico tecnico = Tecnico.findById(id);

        if (tecnico != null) {
            tecnico.delete();
        } 
    }

    @PUT
    @Path("{id}")
    @Transactional
    public void editar (@PathParam("id") Long id, Tecnico tecnico) {
        Tecnico tecnicoExistente = Tecnico.findById(id);

        if (tecnicoExistente != null) {
            tecnicoExistente.nome = tecnico.nome;
            tecnicoExistente.nacionalidade = tecnico.nacionalidade;
            tecnicoExistente.dataNascimento = tecnico.dataNascimento;
            tecnicoExistente.timeAtual = tecnico.timeAtual;
            tecnicoExistente.titulos = tecnico.titulos;
            tecnicoExistente.idade = tecnico.idade;
            tecnicoExistente.dataInicio = tecnico.dataInicio;

            tecnicoExistente.persist();
        }

}
