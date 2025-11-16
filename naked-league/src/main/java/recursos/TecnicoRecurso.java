package recursos;

import java.util.List;

import entidades.Tecnico;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
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

}
