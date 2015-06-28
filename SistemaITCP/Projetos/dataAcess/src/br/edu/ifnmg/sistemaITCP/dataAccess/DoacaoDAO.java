package br.edu.ifnmg.sistemaITCP.dataAccess;

import br.edu.ifnmg.sistemaITCP.domainModel.Doacao;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.DoacaoRepositorio;
import java.util.List;
import javax.ejb.Singleton;

@Singleton
public class DoacaoDAO extends DAOGenerico<Doacao> implements DoacaoRepositorio {

    public DoacaoDAO() {
        super(Doacao.class);
    }

    @Override
    public List<Doacao> Buscar(Doacao filtro) {
        return Like("tipo", filtro.getTipo())
                .IgualA("entidadeDoadora", filtro.getEntidadeDoadora())
                .IgualA("id", filtro.getId())
                .OrderBy("id", "ASC")
                .Buscar();
    }

}
