package br.edu.ifnmg.sistemaITCP.controllers;

import br.edu.ifnmg.sistemaITCP.domainModel.Acao;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.AcaoRepositorio;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named(value = "acaoController")
@SessionScoped
public class AcaoController extends ControllerGenerico<Acao> implements Serializable {

    public AcaoController() {
        super("listagemAcoes.xhtml", "editarAcao.xhtml");
        entidade = new Acao();
        filtro = new Acao();

    }

    @EJB
    private AcaoRepositorio repositorio;

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
