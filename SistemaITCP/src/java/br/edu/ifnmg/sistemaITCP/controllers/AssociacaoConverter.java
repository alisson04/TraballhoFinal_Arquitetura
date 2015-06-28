package br.edu.ifnmg.sistemaITCP.controllers;

import br.edu.ifnmg.sistemaITCP.domainModel.Associacao;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.AssociacaoRepositorio;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Named(value = "associacaoConverter")
@SessionScoped
public class AssociacaoConverter implements Serializable, Converter {

    public AssociacaoConverter() {
    }

    @EJB
    AssociacaoRepositorio daoAssociacao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;
        } else {
            Long id = Long.parseLong(value);
            return daoAssociacao.Abrir(id);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.toString().equals("")) {
            return "";
        } else {
            Associacao c = (Associacao) value;
            return c.getId().toString();
        }
    }

}
