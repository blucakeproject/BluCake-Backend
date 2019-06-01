package br.com.blucake.api.dto;

import java.util.Objects;

/**
 *
 * @author Lucas Jansen
 */
public class EnviaEmailDTO {

    private String destEmail;
    private String destNome;
    private Long idUsuario;
    private String remetEmail;
    private String remetNome;
    // Tipo 1 - Solicação de Novo Confeiteiro
    // Tipo 2 - Contato com o Confeiteiro por Interesse no Bolo
    private int tipoEnvio;
    private String nomeBolo;
    private String telefone;
    private String assunto;
    private String mensagem;

    public EnviaEmailDTO() {
    }

    public EnviaEmailDTO(String destEmail, String destNome, Long idUsuario, String remetEmail, String remetNome, int tipoEnvio, String nomeBolo, String telefone, String assunto, String mensagem) {
        this.destEmail = destEmail;
        this.destNome = destNome;
        this.idUsuario = idUsuario;
        this.remetEmail = remetEmail;
        this.remetNome = remetNome;
        this.tipoEnvio = tipoEnvio;
        this.nomeBolo = nomeBolo;
        this.telefone = telefone;
        this.assunto = assunto;
        this.mensagem = mensagem;
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

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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

    @Override
    public String toString() {
        return "EnviaEmailDTO{" + "destEmail=" + destEmail + ", destNome=" + destNome + ", idUsuario=" + idUsuario + ", remetEmail=" + remetEmail + ", remetNome=" + remetNome + ", tipoEnvio=" + tipoEnvio + ", nomeBolo=" + nomeBolo + ", telefone=" + telefone + ", assunto=" + assunto + ", mensagem=" + mensagem + '}';
    }

}
