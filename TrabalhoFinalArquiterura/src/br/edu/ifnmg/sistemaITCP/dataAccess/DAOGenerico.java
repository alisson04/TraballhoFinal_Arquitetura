/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemaITCP.dataAccess;

import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.Repositorio;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author petronio
 */
public abstract class DAOGenerico<T> implements Repositorio<T> {

    private EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("TrabalhoFinal_Arquiterura_PU");
    protected EntityManager manager;
    private Class tipo;
    String where = "";
    String orderBy = "";
    String jpql = "select c from ";
    Map<String, Object> parametros = new HashMap<>();

    public DAOGenerico(Class t) {
        manager = fabrica.createEntityManager();
        this.tipo = t;

    }

    public DAOGenerico<T> OrderBy(String campo, String order) {

        if (campo != null) {
            if (orderBy.length() > 0) {
                orderBy += ",";
            }
            orderBy += "c." + campo + " " + order;
        }
        return this;
    }

    public DAOGenerico<T> IgualA(String campo, Object valor) {
        if (where.length() > 0) {
            where += " and ";
        }

        if (valor != null) {
            where = where + "c." + campo + " = :" + campo;
            parametros.put(campo, valor);
        }
        return this;
    }

    public DAOGenerico<T> Like(String campo, String valor) {
        if (where.length() > 0) {
            where += " and ";
        }

        if (valor != null) {
            where = where + "c." + campo + " like '%" + valor + "%'";
        }
        return this;
    }

    @Override
    public boolean Salvar(T obj) {
        EntityTransaction t = manager.getTransaction();
        try {
            t.begin();
            manager.persist(obj);
            t.commit();
            return true;
        } catch (Exception e) {
            t.rollback();
            return false;
        }
    }

    @Override
    public T Abrir(Long id) {
        return (T) manager.find(tipo, id);
    }

    @Override
    public boolean Apagar(T obj) {
        EntityTransaction t = manager.getTransaction();
        try {
            t.begin();
            manager.remove(obj);
            t.commit();
            return true;
        } catch (Exception e) {
            t.rollback();
            return false;
        }
    }

    @Override
    public abstract List<T> Buscar(T filtro);

}
