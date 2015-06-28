
package br.edu.ifnmg.sistemaITCP.domainModel.repositorio;

import java.util.List;


public interface Repositorio<T> {

    public boolean Salvar(T obj);
    public T Abrir(Long id);
    public boolean Apagar(T obj);
    public List<T> Buscar(T filtro);

}
