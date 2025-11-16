package recursos;

import java.util.List;

import entidades.Jogador;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
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


}
