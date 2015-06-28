
package br.edu.ifnmg.sistemaITCP.domainModel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Doacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tipo", length = 50, nullable = false)
    private String tipo;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_doacao", nullable = false)
    private Date dataDoacao;

    @Column(name = "entidade_doadora", length = 50, nullable = false)
    private String entidadeDoadora;

    @ManyToOne(cascade = CascadeType.ALL)
    private GrupoSolidario grupoSolidario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDataDoacao() {
        return dataDoacao;
    }

    public void setDataDoacao(Date dataDoacao) {
        this.dataDoacao = dataDoacao;
    }

    public String getEntidadeDoadora() {
        return entidadeDoadora;
    }

    public void setEntidadeDoadora(String entidadeDoadora) {
        this.entidadeDoadora = entidadeDoadora;
    }

    public GrupoSolidario getGrupoSolidario() {
        return grupoSolidario;
    }

    public void setGrupoSolidario(GrupoSolidario grupoSolidario) {
        this.grupoSolidario = grupoSolidario;
    }

 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doacao)) {
            return false;
        }
        Doacao other = (Doacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.sistemaITCP.entidade.Doacao[ id=" + id + " ]";
    }

}
