/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemaITCP.dataAccess;

import br.edu.ifnmg.sistemaITCP.domainModel.Associacao;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.AssociacaoRepositorio;
import java.util.List;

/**
 *
 * @author Amauri
 */
public class AssociacaoDAO extends DAOGenerico<Associacao> implements AssociacaoRepositorio {

    public AssociacaoDAO() {
        super(Associacao.class);
    }

    @Override
    public List<Associacao> Buscar(Associacao filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
