package br.com.blucake.api.models;

import java.io.Serializable;
import java.util.Date;
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

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dataEnvio;

    public EmailEnviado() {

    }

}
