package br.edu.ifnmg.sistemaITCP.controllers;

import br.edu.ifnmg.sistemaITCP.domainModel.Cooperativa;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.CooperativaRepositorio;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Thales
 */
@Named(value = "cooperativaController")
@SessionScoped
public class CooperativaController extends ControllerGenerico<Cooperativa> implements Serializable {

    public CooperativaController() {
        super("listagemCooperativas.xhtml", "editarCooperativa.xhtml");
        entidade = new Cooperativa();
        filtro = new Cooperativa();
    }

    @EJB
    private CooperativaRepositorio repositorio;

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }


  
}
