package br.edu.ifnmg.sistemaITCP.controllers;

import br.edu.ifnmg.sistemaITCP.domainModel.Cooperativa;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.CooperativaRepositorio;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Named(value = "cooperativaConverter")
@SessionScoped
public class CooperativaConverter implements Serializable, Converter {

    public CooperativaConverter() {
    }

    @EJB
    CooperativaRepositorio daoCooperativa;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;
        } else {
            Long id = Long.parseLong(value);
            return daoCooperativa.Abrir(id);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.toString().equals("")) {
            return "";
        } else {
            Cooperativa c = (Cooperativa) value;
            return c.getId().toString();
        }
    }

}
