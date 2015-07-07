package br.edu.ifnmg.sistemaITCP.dataAccess;

import br.edu.ifnmg.sistemaITCP.domainModel.Produto;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.ProdutoRepositorio;
import java.util.List;
import javax.ejb.Singleton;

@Singleton
public class ProdutoDAO extends DAOGenerico<Produto> implements ProdutoRepositorio {

    public ProdutoDAO() {
        super(Produto.class);
    }

    @Override
    public List<Produto> Buscar(Produto filtro) {
        return IgualA("nome", filtro.getNome())
                .IgualA("id", filtro.getId())
                .OrderBy("nome", "ASC")
                .Buscar();
    }

}
