package br.edu.ifnmg.sistemaITCP.dataAccess;

import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.Repositorio;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class DAOGenerico<T> implements Repositorio<T> {

    @PersistenceContext(name = "SistemaITCPPU")
    protected EntityManager manager;
    private Class tipo;
    String where = "";
    String orderby = "";
    String jpql = "select c from ";
    Map<String, Object> parametros = new HashMap<>();

    public DAOGenerico(Class t) {
        this.tipo = t;
    }

    public DAOGenerico<T> OrderBy(String campo, String order) {

        if (campo != null) {
            if (orderby.length() > 0) {
                orderby += ",";
            }

            orderby += "c." + campo + " " + order;
        }

        return this;
    }

    public DAOGenerico<T> IgualA(String campo, Object valor) {

        if (valor == null || valor.toString().isEmpty()) {
            return this;
        }

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

        if (valor == null || valor.isEmpty()) {
            return this;
        }

        if (where.length() > 0) {
            where += " and ";
        }

        if (valor != null) {
            where = where + "c." + campo + " like '%" + valor + "%'";
        }

        return this;
    }

    public List<T> Buscar() {
        try {

            jpql += tipo.getSimpleName() + " c";

            if (where.length() > 0) {
                jpql = jpql + " where " + where;
            }

            if (orderby.length() > 0) {
                jpql = jpql + " order by " + orderby;
            }

            Query consulta = manager.createQuery(jpql);

            for (String parametro : parametros.keySet()) {
                consulta.setParameter(parametro, parametros.get(parametro));
            }
            return consulta.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            where = "";
            jpql = "select c from ";
            orderby = "";
            parametros = new HashMap<>();
        }

    }

    @Override
    public boolean Salvar(T obj) {
        try {
            manager.merge(obj);
            manager.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public T Abrir(Long id) {
        return (T) manager.find(tipo, id);
    }

    @Override
    public boolean Apagar(T obj) {
        try {
            obj = (T) manager.merge(obj);
            manager.remove(obj);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public abstract List<T> Buscar(T filtro);

}
