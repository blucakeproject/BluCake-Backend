package br.com.blucake.api.models;

import br.com.blucake.api.dto.UsuarioDTO;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.blucake.api.enums.PerfilEnum;
import br.com.blucake.api.utils.SenhaUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityListeners;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "usuario")
public class Usuario implements Serializable {
   
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha", updatable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "perfil")
    private PerfilEnum perfil;

    @Column(name = "nomeContato")
    private String nomeContato;

    @Column(name = "telefoneCelular")
    private String telefone1;

    @Column(name = "telefoneCelular2")
    private String telefone2;

    @Column(name = "telefoneFixo")
    private String telefoneFixo;

    @Column(name = "rg")
    private String rg;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "rua")
    private String rua;

    @Column(name = "numero")
    private Long numero;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "cep")
    private String cep;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataContrato")
    private Date dataContrato;

    @Column(name = "dataCriacao", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dataCriacao;
    
    @Column(name = "dataAtualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date dataAtualizacao;

    @Column(name = "usuarioCriacao")
    @CreatedBy
    private String usuarioCriacao;

    @Column(name = "usuarioAtualizacao")
    @LastModifiedBy
    private String usuarioAtualizacao;

    public Usuario() {
    }

    public Usuario(Long id, String nome, String email, String senha, PerfilEnum perfil, String nomeContato, String telefone1, String telefone2, String telefoneFixo, String rg, String cpf, String rua, Long numero, String complemento, String bairro, String cidade, String estado, String cep, Date dataContrato) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = SenhaUtils.gerarBCrypt(senha);
        this.perfil = perfil;
        this.nomeContato = nomeContato;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.telefoneFixo = telefoneFixo;
        this.rg = rg;
        this.cpf = cpf;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.dataContrato = dataContrato;
    }

    public Usuario(Long id, String nome, String email, String senha, PerfilEnum perfil, String nomeContato, String telefone1, String telefone2, String telefoneFixo, String rg, String cpf, String rua, Long numero, String complemento, String bairro, String cidade, String estado, String cep, Date dataContrato, Date dataCriacao, Date dataAtualizacao, String usuarioCriacao, String usuarioAtualizacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
        this.nomeContato = nomeContato;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.telefoneFixo = telefoneFixo;
        this.rg = rg;
        this.cpf = cpf;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.dataContrato = dataContrato;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        this.usuarioCriacao = usuarioCriacao;
        this.usuarioAtualizacao = usuarioAtualizacao;
    }
    
    
    
    public Usuario(UsuarioDTO obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.email = obj.getEmail();
        this.perfil = obj.getPerfil();
        this.senha = obj.getSenha();        
        this.nomeContato = obj.getNomeContato();
        this.telefone1 = obj.getTelefone1();
        this.telefone2 = obj.getTelefone2();
        this.telefoneFixo = obj.getTelefoneFixo();
        this.rg = obj.getRg();
        this.cpf = obj.getCpf();
        this.rua = obj.getRua();
        this.numero = obj.getNumero();
        this.complemento = obj.getComplemento();
        this.bairro = obj.getBairro();
        this.cidade = obj.getCidade();
        this.estado = obj.getEstado();
        this.cep = obj.getCep();
        this.dataContrato = obj.getDataContrato();
        this.dataAtualizacao = obj.getDataAtualizacao();
        this.dataCriacao = obj.getDataCriacao();
        this.usuarioCriacao = obj.getUsuarioCriacao();
        this.usuarioAtualizacao = obj.getUsuarioAtualizacao();
    }
    
    private String obterSenhaCrypt(UsuarioDTO obj){
    
        if(obj.getId() == null){
            return SenhaUtils.gerarBCrypt(obj.getSenha());
        }else{
            return obj.getSenha();
        }    
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public PerfilEnum getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilEnum perfil) {
        this.perfil = perfil;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Date getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(Date dataContrato) {
        this.dataContrato = dataContrato;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getUsuarioCriacao() {
        return this.usuarioCriacao;
    }

    public void setUsuarioCriacao(String usuarioCriacao) {
        this.usuarioCriacao = usuarioCriacao;
    }

    public String getUsuarioAtualizacao() {
        return this.usuarioAtualizacao;
    }

    public void setUsuarioAtualizacao(String usuarioAtualizacao) {
        this.usuarioAtualizacao = usuarioAtualizacao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", perfil=" + perfil + ", nomeContato=" + nomeContato + ", telefone1=" + telefone1 + ", telefone2=" + telefone2 + ", telefoneFixo=" + telefoneFixo + ", rg=" + rg + ", cpf=" + cpf + ", rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep + '}';
    }

}
