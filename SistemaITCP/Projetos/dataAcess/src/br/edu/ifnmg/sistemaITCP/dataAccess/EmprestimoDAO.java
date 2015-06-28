package br.edu.ifnmg.sistemaITCP.dataAccess;

import br.edu.ifnmg.sistemaITCP.domainModel.Emprestimo;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.EmprestimoRepositorio;
import java.util.List;
import javax.ejb.Singleton;

@Singleton
public class EmprestimoDAO extends DAOGenerico<Emprestimo> implements EmprestimoRepositorio {

    public EmprestimoDAO() {
        super(Emprestimo.class);
    }

    @Override
    public List<Emprestimo> Buscar(Emprestimo filtro) {
        return Like("banco", filtro.getBanco())
                .OrderBy("banco", "ASC")
                .Buscar();
    }

}
