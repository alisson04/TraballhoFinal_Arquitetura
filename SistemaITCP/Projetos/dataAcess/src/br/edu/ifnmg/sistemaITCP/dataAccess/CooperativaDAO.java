
package br.edu.ifnmg.sistemaITCP.dataAccess;

import br.edu.ifnmg.sistemaITCP.domainModel.Cooperativa;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.CooperativaRepositorio;
import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.Query;


@Singleton
public class CooperativaDAO extends DAOGenerico<Cooperativa> implements CooperativaRepositorio {

    public CooperativaDAO() {
        super(Cooperativa.class);
    }

    @Override
    public List<Cooperativa> Buscar(Cooperativa filtro) {
        return Like("nome", filtro.getNome())
                .IgualA("id", filtro.getId())
                .IgualA("cnpj", filtro.getCnpj())
                .OrderBy("nome", "ASC")
                .Buscar();
    }

    
    public Cooperativa AbrirPorCNPJ(String cnpj) {
        Query consulta = manager.createQuery("select o from Cooperativa o "
                + "where o.cnpj = :cnpj");
        consulta.setParameter("cpf", cnpj);
        return (Cooperativa) consulta.getSingleResult();
    }

}
