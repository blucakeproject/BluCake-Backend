package br.com.blucake.api.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author Lucas Jansen
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "ingrediente")
public class Ingrediente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nome;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dataCadatro;

    @OneToMany(mappedBy = "ingrediente")
    private List<IngredienteReceita> ingredienteReceitas;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Ingrediente() {
    }

    public Ingrediente(String nome) {
        this(null, nome, null);
    }

    public Ingrediente(Long id, String nome, Date dataCadatro) {
        this.id = id;
        this.nome = nome;
        this.dataCadatro = dataCadatro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCadatro() {
        return dataCadatro;
    }

    public void setDataCadatro(Date dataCadatro) {
        this.dataCadatro = dataCadatro;
    }

    public List<IngredienteReceita> getIngredienteReceitas() {
        return ingredienteReceitas;
    }

    public void setIngredienteReceitas(List<IngredienteReceita> ingredienteReceitas) {
        this.ingredienteReceitas = ingredienteReceitas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ingrediente other = (Ingrediente) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Ingrediente{" + "id=" + id + ", nome=" + nome + ", dataCadatro=" + dataCadatro + ", ingredienteReceitas=" + ingredienteReceitas + ", usuario=" + usuario + '}';
    }

}
