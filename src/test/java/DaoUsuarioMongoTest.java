import br.com.scorpion.poc.dao.UsuarioDao;
import br.com.scorpion.poc.model.Status;
import br.com.scorpion.poc.model.Usuario;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class DaoUsuarioMongoTest {


    @Test
    public void usuariosTest(){


        UsuarioDao dao = new UsuarioDao();
        dao.inserir( new Usuario("eita@gmail.com","senha1" , Status.ATIVO));
        dao.inserir( new Usuario("toncarvalho@gmail.com","senha2" , Status.ATIVO));
        dao.inserir( new Usuario("rebeca@gmail.com","senha3" , Status.ATIVO));
        dao.inserir( new Usuario("treta@gmail.com","senha4" , Status.INATIVO));

        //dao.excluirTodosAtivos();

        List<Usuario> todos = dao.listarTodos();

        for( Usuario u : todos) {
            System.out.println(u);
        }



    }
}
