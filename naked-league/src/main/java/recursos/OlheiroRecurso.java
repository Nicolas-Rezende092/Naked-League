package recursos;

import java.util.List;

import entidades.Olheiro;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
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
}
