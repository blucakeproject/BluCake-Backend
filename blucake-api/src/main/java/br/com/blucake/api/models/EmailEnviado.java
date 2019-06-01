package br.com.blucake.api.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "email_enviado")
public class EmailEnviado implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String destEmail;

    @Column
    private String destNome;

    @Column
    private String remetEmail;

    @Column
    private String remetNome;

    // Tipo 1 - Solicação de Novo Confeiteiro
    // Tipo 2 - Contato com o Confeiteiro por Interesse no Bolo
    @Column
    private int tipoEnvio;

    @Column
    private String nomeBolo;

    @Column
    private String telefone;

    @Column
    private String assunto;

    @Column
    private String mensagem;

    @Column
    private boolean enviado;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dataEnvio;

    public EmailEnviado() {

    }

    public EmailEnviado(Long id, String destEmail, String destNome, String remetEmail, String remetNome, int tipoEnvio, String nomeBolo, String telefone, String assunto, String mensagem, boolean enviado, Long usuario, Date dataEnvio) {
        this.id = id;
        this.destEmail = destEmail;
        this.destNome = destNome;
        this.remetEmail = remetEmail;
        this.remetNome = remetNome;
        this.tipoEnvio = tipoEnvio;
        this.nomeBolo = nomeBolo;
        this.telefone = telefone;
        this.assunto = assunto;
        this.mensagem = mensagem;
        this.enviado = enviado;
        this.usuario.setId(usuario);
        this.dataEnvio = dataEnvio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestEmail() {
        return destEmail;
    }

    public void setDestEmail(String destEmail) {
        this.destEmail = destEmail;
    }

    public String getDestNome() {
        return destNome;
    }

    public void setDestNome(String destNome) {
        this.destNome = destNome;
    }

    public String getRemetEmail() {
        return remetEmail;
    }

    public void setRemetEmail(String remetEmail) {
        this.remetEmail = remetEmail;
    }

    public String getRemetNome() {
        return remetNome;
    }

    public void setRemetNome(String remetNome) {
        this.remetNome = remetNome;
    }

    public int getTipoEnvio() {
        return tipoEnvio;
    }

    public void setTipoEnvio(int tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
    }

    public String getNomeBolo() {
        return nomeBolo;
    }

    public void setNomeBolo(String nomeBolo) {
        this.nomeBolo = nomeBolo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isEnviado() {
        return enviado;
    }

    public void setEnviado(boolean enviado) {
        this.enviado = enviado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    @Override
    public String toString() {
        return "EmailEnviado{" + "id=" + id + ", destEmail=" + destEmail + ", destNome=" + destNome + ", remetEmail=" + remetEmail + ", remetNome=" + remetNome + ", tipoEnvio=" + tipoEnvio + ", nomeBolo=" + nomeBolo + ", telefone=" + telefone + ", assunto=" + assunto + ", mensagem=" + mensagem + ", enviado=" + enviado + ", usuario=" + usuario + ", dataEnvio=" + dataEnvio + '}';
    }

}
