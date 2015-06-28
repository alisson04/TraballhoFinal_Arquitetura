package br.edu.ifnmg.sistemaITCP.controllers;

import br.edu.ifnmg.sistemaITCP.domainModel.GrupoSolidario;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.GrupoSolidarioRepositorio;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Named(value = "grupoConverter")
@SessionScoped
public class grupoConverter implements Serializable, Converter {

    public grupoConverter() {
    }

    @EJB
    GrupoSolidarioRepositorio daoGrupo;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;
        } else {
            Long id = Long.parseLong(value);
            return daoGrupo.Abrir(id);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.toString().equals("")) {
            return "";
        } else {
            GrupoSolidario c = (GrupoSolidario) value;
            return c.getId().toString();
        }
    }

}
