package br.edu.ifnmg.sistemaITCP.controllers;

import br.edu.ifnmg.sistemaITCP.domainModel.Usuario;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.UsuarioRepositorio;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Thales
 */
@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController extends ControllerGenerico<Usuario> implements Serializable {

    public UsuarioController() {
        super("listagemUsuarios.xhtml", "editarUsuario.xhtml");

        entidade = new Usuario();

        filtro = new Usuario();

    }

    @EJB
    private UsuarioRepositorio repositorio;

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
