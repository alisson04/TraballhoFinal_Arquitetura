/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemaITCP.dataAccess;

import br.edu.ifnmg.sistemaITCP.domainModel.Pessoa;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.PessoaRepositorio;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Amauri
 */
public class PessoaDAO extends DAOGenerico<Pessoa> implements PessoaRepositorio {

    public PessoaDAO() {
        super(Pessoa.class);
    }

    @Override
    public List<Pessoa> Buscar(Pessoa filtro) {
        return Like("nome", filtro.getNome())
               .IgualA("id", filtro.getId())
               .IgualA("cpf", filtro.getCpf())
               .OrderBy("nome", "ASC")
               .Buscar(filtro);
    }

    @Override
    public Pessoa AbrirPorCPF(String cpf) {
        Query consulta = manager.createQuery("select o from Cliente o "
                + "where o.cpf = :cpf");
        consulta.setParameter("cpf", cpf);
        return (Pessoa)consulta.getSingleResult();
    }

}
