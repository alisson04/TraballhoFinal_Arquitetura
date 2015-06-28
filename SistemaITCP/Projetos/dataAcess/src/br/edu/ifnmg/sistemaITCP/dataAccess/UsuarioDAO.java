package br.edu.ifnmg.sistemaITCP.dataAccess;

import br.edu.ifnmg.sistemaITCP.domainModel.Usuario;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.UsuarioRepositorio;
import java.util.List;
import javax.ejb.Singleton;

@Singleton
public class UsuarioDAO extends DAOGenerico<Usuario> implements UsuarioRepositorio {

    public UsuarioDAO() {
        super(Usuario.class);
    }

    @Override
    public List<Usuario> Buscar(Usuario filtro) {
        return Like("userName", filtro.getUserName())
                .IgualA("id", filtro.getId())
                .OrderBy("userName", "ASC")
                .Buscar();
    }

}
