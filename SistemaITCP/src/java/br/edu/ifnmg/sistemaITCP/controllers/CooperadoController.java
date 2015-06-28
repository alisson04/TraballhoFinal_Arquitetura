package br.edu.ifnmg.sistemaITCP.controllers;

import br.edu.ifnmg.sistemaITCP.domainModel.Cooperado;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.CooperadoRepositorio;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named(value = "cooperadoController")
@SessionScoped
public class CooperadoController extends ControllerGenerico<Cooperado> implements Serializable {

    public CooperadoController() {
        super("listagemCooperados.xhtml", "editarCooperado.xhtml");
        entidade = new Cooperado();
        filtro = new Cooperado();

    }

    @EJB
    private CooperadoRepositorio repositorio;

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }
}
