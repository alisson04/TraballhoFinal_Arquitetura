package br.edu.ifnmg.sistemaITCP.dataAccess;

import br.edu.ifnmg.sistemaITCP.domainModel.Acao;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.AcaoRepositorio;
import java.util.List;
import javax.ejb.Singleton;

@Singleton
public class AcaoDAO extends DAOGenerico<Acao> implements AcaoRepositorio {

    public AcaoDAO() {
        super(Acao.class);
    }

    @Override
    public List<Acao> Buscar(Acao filtro) {

        return IgualA("NomeAcao", filtro.getNomeAcao())
                .IgualA("id", filtro.getId())
                .OrderBy("NomeAcao", "ASC")
                .Buscar();
    }

}
