package br.edu.ifnmg.sistemaITCP.controllers;

import br.edu.ifnmg.sistemaITCP.domainModel.Associacao;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.AssociacaoRepositorio;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named(value = "associacaoController")
@SessionScoped
public class AssociacaoController extends ControllerGenerico<Associacao> implements Serializable {

    public AssociacaoController() {
        super("listagemAssociacoes.xhtml", "editarAssociacao.xhtml");
        entidade = new Associacao();
        filtro = new Associacao();

    }

    @EJB
    private AssociacaoRepositorio repositorio;

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }
}
