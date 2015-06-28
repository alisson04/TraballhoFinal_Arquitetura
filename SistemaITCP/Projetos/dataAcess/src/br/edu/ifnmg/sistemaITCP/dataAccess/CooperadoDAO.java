package br.edu.ifnmg.sistemaITCP.dataAccess;

import br.edu.ifnmg.sistemaITCP.domainModel.Cooperado;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.CooperadoRepositorio;
import java.util.List;
import javax.ejb.Singleton;

@Singleton
public class CooperadoDAO extends DAOGenerico<Cooperado> implements CooperadoRepositorio {

    public CooperadoDAO() {
        super(Cooperado.class);
    }

    @Override
    public List<Cooperado> Buscar(Cooperado filtro) {
        return IgualA("nome", filtro.getNome())
                .IgualA("id", filtro.getId())
                .IgualA("cpf", filtro.getCpf())
                .OrderBy("nome", "ASC")
                .Buscar();
    }

}
