package recursos;

import java.util.List;

import entidades.Equipe;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("equipe")
public class EquipeRecurso {
    @GET
    public List<Equipe> listar() {
        return Equipe.listAll(Sort.ascending("nome"));
    }

    @POST
    @Transactional
    public void salvar(Equipe equipe) {
        equipe.persist();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void excluir (@PathParam("id") Long id) {
        Equipe equipe = Equipe.findById(id);

        if (equipe != null) {
            equipe.delete();
        } 
    }


}
