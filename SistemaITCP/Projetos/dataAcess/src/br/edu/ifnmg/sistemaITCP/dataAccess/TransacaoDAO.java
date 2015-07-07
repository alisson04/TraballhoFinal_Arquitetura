package br.edu.ifnmg.sistemaITCP.dataAccess;

import br.edu.ifnmg.sistemaITCP.domainModel.Transacao;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.TransacaoRepositorio;
import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.Query;

@Singleton
public class TransacaoDAO extends DAOGenerico<Transacao> implements TransacaoRepositorio {

    public TransacaoDAO() {
        super(Transacao.class);
    }

    @Override
    public List<Transacao> Buscar(Transacao filtro) {
        return IgualA("tipo", filtro.getTipo())
                .IgualA("id", filtro.getId())
                .IgualA("id", filtro.getValor())
                .IgualA("id", filtro.getDataTransacao())
                .OrderBy("tipo", "ASC")
                .Buscar();
    }

    @Override
    public List<Transacao> BuscarTransacao(Transacao obj) {
        String sql = "select o from Transacao o left join fetch o.linhas";

        Query consulta = manager.createQuery(sql);

        return consulta.getResultList();
    }

}
