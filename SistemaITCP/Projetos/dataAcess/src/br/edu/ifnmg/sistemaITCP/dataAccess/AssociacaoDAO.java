/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemaITCP.dataAccess;

import br.edu.ifnmg.sistemaITCP.domainModel.Associacao;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.AssociacaoRepositorio;
import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.Query;

/**
 *
 * @author Amauri
 */

@Singleton
public class AssociacaoDAO extends DAOGenerico<Associacao> implements AssociacaoRepositorio {

    public AssociacaoDAO() {
        super(Associacao.class);
    }

  @Override
    public List<Associacao> Buscar(Associacao filtro) {
        return Like("nome", filtro.getNome())
                .IgualA("id", filtro.getId())
               // .IgualA("cpf", filtro.getCnpj())
                .OrderBy("nome", "ASC")
                .Buscar();
    }

    public Associacao AbrirPorCNPJ(String cnpj) {
        Query consulta = manager.createQuery("select o from Associacao o "
                + "where o.cnpj = :cnpj");
        consulta.setParameter("cpf", cnpj);
        return (Associacao) consulta.getSingleResult();
    }

}
