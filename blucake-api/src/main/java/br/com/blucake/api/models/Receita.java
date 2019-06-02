package br.com.blucake.api.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.NumberFormat;

/**
 *
 * @author Lucas Jansen
 */
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "receita")
public class Receita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long receita_id;

    @Column
    private String nome;

    @Column
    private String descricao;

    @Column
    private Double preco;

    @Column
    private String imagem;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dataCadastro;
        
    @ManyToMany
    @JoinTable( name= "ingrediente_receita",
                 joinColumns =@JoinColumn(name="receita_id"),
                 inverseJoinColumns = @JoinColumn(name="ingrediente_id"))   
    private List<Ingrediente> ingrediente;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Receita() {
    }

    public Receita(String nome, String descricao, Double preco, String imagem, List<Ingrediente> ingrediente, Usuario usuario) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imagem = imagem;
        this.ingrediente = ingrediente;
        this.usuario = usuario;
    }
    
    

    public Receita(long id, String nome, String descricao, Double preco, String imagem, Date dataCadastro, List<Ingrediente> ingredienteReceitas, Usuario usuario) {
        this.receita_id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imagem = imagem;
        this.dataCadastro = dataCadastro;
        this.ingrediente = ingrediente;
        this.usuario = usuario;
    }

    public long getId() {
        return receita_id;
    }

    public void setId(long id) {
        this.receita_id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<Ingrediente> getIngredienteReceitas() {
        return ingrediente;
    }

    public void setIngredienteReceitas(List<Ingrediente> ingredienteReceitas) {
        this.ingrediente = ingredienteReceitas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (int) (this.receita_id ^ (this.receita_id >>> 32));
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
        final Receita other = (Receita) obj;
        if (this.receita_id != other.receita_id) {
            return false;
        }
        return true;
    }

    

}
