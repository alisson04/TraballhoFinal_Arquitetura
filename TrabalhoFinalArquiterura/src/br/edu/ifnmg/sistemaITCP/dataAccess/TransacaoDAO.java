/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemaITCP.dataAccess;

import br.edu.ifnmg.sistemaITCP.domainModel.Transacao;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.TransacaoRepositorio;
import java.util.List;

/**
 *
 * @author Amauri
 */
public class TransacaoDAO extends DAOGenerico<Transacao> implements TransacaoRepositorio{

    public TransacaoDAO() {
        super(Transacao.class);
    }

    @Override
    public List<Transacao> Buscar(Transacao filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
