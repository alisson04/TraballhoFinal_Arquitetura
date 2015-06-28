package br.edu.ifnmg.sistemaITCP.controllers;

import br.edu.ifnmg.sistemaITCP.domainModel.Atividade;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.AtividadeRepositorio;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named(value = "atividadeController")
@SessionScoped
public class AtividadeController extends ControllerGenerico<Atividade> implements Serializable {

    public AtividadeController() {
        super("listagemAtividades.xhtml", "editarAtividade.xhtml");
        entidade = new Atividade();
        filtro = new Atividade();

    }

    @EJB
    private AtividadeRepositorio repositorio;

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
