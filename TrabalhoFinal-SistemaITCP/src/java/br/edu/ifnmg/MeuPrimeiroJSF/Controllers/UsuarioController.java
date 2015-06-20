/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.MeuPrimeiroJSF.Controllers;

import br.edu.ifnmg.sistemaITCP.domainModel.Usuario;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.UsuarioRepositorio;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Amauri
 */
@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController extends ControllerGenerico<Usuario> implements Serializable{
    
    /**
     * Creates a new instance of testeController
     */
    public UsuarioController() {
        super("listagemUsuarios.xhtml","editarUsuario.xhtml");
        entidade = new Usuario();
        filtro = new Usuario();
    }
    
    @EJB
    private UsuarioRepositorio repositorio;

    @PostConstruct
    public void configurar(){
        setDao(repositorio);
    }
}
