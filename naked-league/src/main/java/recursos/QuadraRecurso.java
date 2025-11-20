package recursos;

import java.util.List;

import entidades.Quadra;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("quadra")
public class QuadraRecurso {
    @GET
    public List<Quadra> listar() {
        return Quadra.listAll(Sort.ascending("nome"));
    }

    @POST
    @Transactional
    public void salvar(Quadra quadra) {
        quadra.persist();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void excluir (@PathParam("id") Long id) {
        Quadra quadra = Quadra.findById(id);

        if (quadra != null) {
            quadra.delete();
        } 
    }

}
