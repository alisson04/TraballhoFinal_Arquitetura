package br.edu.ifnmg.sistemaITCP.controllers;

import br.edu.ifnmg.sistemaITCP.domainModel.Produto;
import br.edu.ifnmg.sistemaITCP.domainModel.Transacao;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.TransacaoRepositorio;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named(value = "transacaoController")
@SessionScoped
public class TransacaoController extends ControllerGenerico<Transacao> implements Serializable {

    Produto produto;

    public TransacaoController() {
        super("listagemTransacoes.xhtml", "editarTransacao.xhtml");
        entidade = new Transacao();
        filtro = new Transacao();
        produto = new Produto();
    }

    @EJB
    private TransacaoRepositorio repositorio;

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void addProduto() {
        entidade.addProdutos(produto);
        produto = new Produto();
    }

    public void RemoverProduto(Produto prod) {
        entidade.removeProdutos(prod);
        produto = new Produto();
    }

}
