package br.edu.ifnmg.sistemaITCP.controllers;

import br.edu.ifnmg.sistemaITCP.domainModel.Associado;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.AssociadoRepositorio;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named(value = "associadoController")
@SessionScoped
public class AssociadoController extends ControllerGenerico<Associado> implements Serializable {

    public AssociadoController() {
        super("listagemAssociados.xhtml", "editarAssociado.xhtml");
        entidade = new Associado();
        filtro = new Associado();

    }

    @EJB
    private AssociadoRepositorio repositorio;

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }
}
