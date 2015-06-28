package br.edu.ifnmg.sistemaITCP.dataAccess;

import br.edu.ifnmg.sistemaITCP.domainModel.Associado;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.AssociadoRepositorio;
import java.util.List;
import javax.ejb.Singleton;

@Singleton
public class AssociadoDAO extends DAOGenerico<Associado> implements AssociadoRepositorio {

    public AssociadoDAO() {
        super(Associado.class);
    }

    @Override
    public List<Associado> Buscar(Associado filtro) {
        return Like("nome", filtro.getNome())
                .IgualA("id", filtro.getId())
                .IgualA("cpf", filtro.getCpf())
                .OrderBy("nome", "ASC")
                .Buscar();
    }

}
