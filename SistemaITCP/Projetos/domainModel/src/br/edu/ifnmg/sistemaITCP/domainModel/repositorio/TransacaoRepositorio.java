package br.edu.ifnmg.sistemaITCP.domainModel.repositorio;

import br.edu.ifnmg.sistemaITCP.domainModel.Transacao;
import java.util.List;
import javax.ejb.Local;

@Local
public interface TransacaoRepositorio extends Repositorio<Transacao> {

    public List<Transacao> BuscarTransacao(Transacao filtro);
}
