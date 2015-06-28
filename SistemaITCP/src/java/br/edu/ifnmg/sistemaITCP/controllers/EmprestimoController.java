package br.edu.ifnmg.sistemaITCP.controllers;

import br.edu.ifnmg.sistemaITCP.domainModel.Emprestimo;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.EmprestimoRepositorio;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Thales
 */
@Named(value = "emprestimoController")
@SessionScoped
public class EmprestimoController extends ControllerGenerico<Emprestimo> implements Serializable {

    public EmprestimoController() {
        super("listagemEmprestimos.xhtml", "editarEmprestimo.xhtml");
        entidade = new Emprestimo();

        filtro = new Emprestimo();
    }

    @EJB
    private EmprestimoRepositorio repositorio;

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }
}
