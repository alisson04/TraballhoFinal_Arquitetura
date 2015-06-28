package br.edu.ifnmg.sistemaITCP.controllers;

import br.edu.ifnmg.sistemaITCP.domainModel.Funcionario;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.FuncionarioRepositorio;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Named(value = "funcionarioConverter")
@SessionScoped
public class FuncionarioConverter implements Serializable, Converter {

    public FuncionarioConverter() {
    }

    @EJB
    FuncionarioRepositorio daoFuncionario;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;
        } else {
            Long id = Long.parseLong(value);
            return daoFuncionario.Abrir(id);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.toString().equals("")) {
            return "";
        } else {
            Funcionario c = (Funcionario) value;
            return c.getId().toString();
        }
    }

}
