package br.com.blucake.api.models;

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
@Table(name = "receita")
public class Receita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nome;

    @Column
    private String descricao;

    @Column
    private Double preco;

    @Column(nullable = true)
    private String imagem;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dataCadastro;

    @OneToMany(mappedBy = "receita")
    private List<IngredienteReceita> ingredienteReceitas;

    @Column()
    @OneToMany(mappedBy = "receita")
    private List<EmailEnviado> emailEnviados;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Receita() {
    }

    public Receita(Long id) {
        this.id = id;
    }

    public Receita(Long id, String nome, String descricao, Double preco, String imagem, Date dataCadastro, Long idUsuario) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imagem = imagem;
        this.dataCadastro = dataCadastro;
        this.usuario = new Usuario(idUsuario);
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

    public List<IngredienteReceita> getIngredienteReceitas() {
        return ingredienteReceitas;
    }

    public void setIngredienteReceitas(List<IngredienteReceita> ingredienteReceitas) {
        this.ingredienteReceitas = ingredienteReceitas;
    }

    public List<EmailEnviado> getEmailEnviados() {
        return emailEnviados;
    }

    public void setEmailEnviados(List<EmailEnviado> emailEnviados) {
        this.emailEnviados = emailEnviados;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Receita{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", imagem=" + imagem + ", dataCadastro=" + dataCadastro + ", ingredienteReceitas=" + ingredienteReceitas + ", emailEnviados=" + emailEnviados + ", usuario=" + usuario + '}';
    }

}
