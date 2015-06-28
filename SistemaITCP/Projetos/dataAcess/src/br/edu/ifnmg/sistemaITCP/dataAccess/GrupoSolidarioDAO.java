
package br.edu.ifnmg.sistemaITCP.dataAccess;

import br.edu.ifnmg.sistemaITCP.domainModel.GrupoSolidario;
import br.edu.ifnmg.sistemaITCP.domainModel.repositorio.GrupoSolidarioRepositorio;
import java.util.List;
import javax.ejb.Singleton;



@Singleton
public class GrupoSolidarioDAO extends DAOGenerico<GrupoSolidario> implements GrupoSolidarioRepositorio {

    public GrupoSolidarioDAO() {
        super(GrupoSolidario.class);
    }

  @Override
    public List<GrupoSolidario> Buscar(GrupoSolidario filtro) {
        return Like("nome", filtro.getNome())
                .IgualA("id", filtro.getId())
               
                .OrderBy("nome", "ASC")
                .Buscar();
    }



}
