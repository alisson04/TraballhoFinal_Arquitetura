package br.edu.ifnmg.sistemaITCP.controllers;

import br.edu.ifnmg.sistemaITCP.domainModel.Produto;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.ProdutoRepositorio;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Named(value = "produtoConverter")
@SessionScoped
public class ProdutoConverter implements Serializable, Converter {

    public ProdutoConverter() {
    }

    @EJB
    ProdutoRepositorio daoProdutoRepositorio;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;
        } else {
            Long id = Long.parseLong(value);
            return daoProdutoRepositorio.Abrir(id);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.toString().equals("")) {
            return "";
        } else {
            Produto c = (Produto) value;
            return c.getId().toString();
        }
    }

}
