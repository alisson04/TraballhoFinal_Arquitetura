package br.edu.ifnmg.sistemaITCP.dataAccess;

import br.edu.ifnmg.sistemaITCP.domainModel.Funcionario;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.FuncionarioRepositorio;
import java.util.List;
import javax.ejb.Singleton;

@Singleton
public class FuncionarioDAO extends DAOGenerico<Funcionario> implements FuncionarioRepositorio {

    public FuncionarioDAO() {
        super(Funcionario.class);
    }

    @Override
    public List<Funcionario> Buscar(Funcionario filtro) {
        return Like("nome", filtro.getNome())
                .IgualA("id", filtro.getId())
                .IgualA("cpf", filtro.getCpf())
                .OrderBy("nome", "ASC")
                .Buscar();
    }

}
