/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemaITCP.domainModel.repositorio;

import br.edu.ifnmg.sistemaITCP.domainModel.Pessoa;

/**
 *
 * @author Amauri
 */
public interface PessoaRepositorio extends Repositorio<Pessoa> {

    public Pessoa AbrirPorCPF(String cpf);
}
