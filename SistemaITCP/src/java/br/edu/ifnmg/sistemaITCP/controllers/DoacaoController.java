package br.edu.ifnmg.sistemaITCP.controllers;

import br.edu.ifnmg.sistemaITCP.domainModel.Doacao;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.DoacaoRepositorio;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Thales
 */
@Named(value = "doacaoController")
@SessionScoped
public class DoacaoController extends ControllerGenerico<Doacao> implements Serializable {

    public DoacaoController() {
        super("listagemDoacoes.xhtml", "editarDoacao.xhtml");
        entidade = new Doacao();
        filtro = new Doacao();

    }

    @EJB
    private DoacaoRepositorio repositorio;

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
