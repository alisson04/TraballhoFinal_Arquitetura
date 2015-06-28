package br.edu.ifnmg.sistemaITCP.dataAccess;

import br.edu.ifnmg.sistemaITCP.domainModel.Atividade;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.AtividadeRepositorio;
import java.util.List;
import javax.ejb.Singleton;

@Singleton
public class AtividadeDAO extends DAOGenerico<Atividade> implements AtividadeRepositorio {

    public AtividadeDAO() {
        super(Atividade.class);
    }

    @Override
    public List<Atividade> Buscar(Atividade filtro) {

        return IgualA("NomeAtividade", filtro.getNomeAtividade())
                .IgualA("id", filtro.getId())
                .OrderBy("NomeAtividade", "ASC")
                .Buscar();
    }

}
