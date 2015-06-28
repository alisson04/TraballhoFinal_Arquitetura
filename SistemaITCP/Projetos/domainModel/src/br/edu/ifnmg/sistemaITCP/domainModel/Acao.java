package br.edu.ifnmg.sistemaITCP.domainModel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Acao implements Serializable {

    public Acao() {

    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_inicio", nullable = false)
    private Date dataInico;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_termino", nullable = false)
    private Date dataTermino;

    @Column(name = "Descrição", nullable = true)
    private String Descricao;

    @Column(name = "Nome_Acao", nullable = true)
    private String NomeAcao;

    @ManyToOne
    private GrupoSolidario grupoSolidario;

    @ManyToOne
    private Funcionario funcionario;

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getNomeAcao() {
        return NomeAcao;
    }

    public void setNomeAcao(String NomeAcao) {
        this.NomeAcao = NomeAcao;
    }

    public GrupoSolidario getGrupoSolidario() {
        return grupoSolidario;
    }

    public void setGrupoSolidario(GrupoSolidario grupoSolidario) {
        this.grupoSolidario = grupoSolidario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataInico() {
        return dataInico;
    }

    public void setDataInico(Date dataInico) {
        this.dataInico = dataInico;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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
        if (!(object instanceof Acao)) {
            return false;
        }
        Acao other = (Acao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.sistemaITCP.entidade.Acao[ id=" + id + " ]";
    }

}
