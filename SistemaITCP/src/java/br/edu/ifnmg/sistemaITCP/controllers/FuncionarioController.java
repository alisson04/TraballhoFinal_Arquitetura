package br.edu.ifnmg.sistemaITCP.controllers;

import br.edu.ifnmg.sistemaITCP.domainModel.Funcionario;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.FuncionarioRepositorio;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;


@Named(value = "funcionarioController")
@SessionScoped
public class FuncionarioController extends ControllerGenerico<Funcionario> implements Serializable {

    public FuncionarioController() {
        super("listagemFuncionarios.xhtml", "editarFuncionario.xhtml");
        entidade = new Funcionario();
        filtro = new Funcionario();

    }

    @EJB
    private FuncionarioRepositorio repositorio;

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }
}
