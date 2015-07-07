package br.edu.ifnmg.sistemaITCP.controllers;

import br.edu.ifnmg.sistemaITCP.domainModel.Produto;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.ProdutoRepositorio;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named(value = "produtoController")
@SessionScoped
public class ProdutoController extends ControllerGenerico<Produto> implements Serializable {

    public ProdutoController() {
        super("listagemAcoes.xhtml", "editarAcao.xhtml");
        entidade = new Produto();
        filtro = new Produto();

    }

    @EJB
    private ProdutoRepositorio repositorio;

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
