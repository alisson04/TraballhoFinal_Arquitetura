package br.edu.ifnmg.sistemaITCP.domainModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Transacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tipo", length = 100, nullable = false)
    private String tipo;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_transacao", nullable = false)
    private Date dataTransacao;

    @ManyToOne
    private GrupoSolidario grupoSolidario;

    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Produto> produtos;

    public Transacao() {

    }

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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public GrupoSolidario getGrupoSolidario() {
        return grupoSolidario;
    }

    public void setGrupoSolidario(GrupoSolidario grupoSolidario) {
        this.grupoSolidario = grupoSolidario;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void addProdutos(Produto prod) {
        if (produtos == null) {
            produtos = new ArrayList<Produto>();
        }
        produtos.add(prod);
    }

    public void removeProdutos(Produto prod) {
        if (produtos.contains(prod)) {
            produtos.remove(prod);
        }
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
        if (!(object instanceof Transacao)) {
            return false;
        }
        Transacao other = (Transacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.sistemaITCP.entidade.Transacao[ id=" + id + " ]";
    }

}
