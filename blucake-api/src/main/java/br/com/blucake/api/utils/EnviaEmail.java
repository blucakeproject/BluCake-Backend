package br.com.blucake.api.utils;

import br.com.blucake.api.dto.EnviaEmailDTO;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author Lucas
 */
public class EnviaEmail {

    private final String smtp = "smtp.gmail.com";
    private final String portaSmtp = "587";
    private final String usuarioSmtp = "projetoblucake@gmail.com";
    private final String senhaUsuarioSmtp = "blucake2019";
    private final DefaultAuthenticator autenticador = new DefaultAuthenticator(usuarioSmtp, senhaUsuarioSmtp);
    private final SimpleEmail email;

    public EnviaEmail() {
        email = new SimpleEmail();
        email.setHostName(smtp);
        email.setSmtpPort(Integer.getInteger(portaSmtp));
        email.setAuthenticator(autenticador);
        email.setTLS(true);
    }

    private boolean validaEnvio(EnviaEmailDTO emailDTO) {
        if (emailDTO == null) {
            return false;
        } else if (emailDTO.getTipoEnvio() == 1) {
            return !(emailDTO.getDestEmail().trim().isEmpty() || emailDTO.getDestNome().trim().isEmpty()
                    || emailDTO.getRemetEmail().trim().isEmpty() || emailDTO.getRemetNome().trim().isEmpty());
        }
        return !(emailDTO.getDestEmail().trim().isEmpty() || emailDTO.getDestNome().trim().isEmpty()
                || emailDTO.getRemetEmail().trim().isEmpty() || emailDTO.getRemetNome().trim().isEmpty()
                || emailDTO.getMensagem().trim().isEmpty());
    }

    public boolean enviar(EnviaEmailDTO emailDTO) {

        if (validaEnvio(emailDTO)) {
            try {
                String msg = "";

                email.setFrom(emailDTO.getDestEmail().trim());
                email.addTo(emailDTO.getRemetEmail().trim());
                if (emailDTO.getAssunto().trim().isEmpty() && emailDTO.getTipoEnvio() == 2) {
                    email.setSubject(emailDTO.getRemetNome().trim() + " - Novo Interessado");
                } else if (emailDTO.getAssunto().trim().isEmpty() && emailDTO.getTipoEnvio() == 1) {
                    email.setSubject("Solicitação de Cadastro de Novo Confeiteiro");
                } else {
                    email.setSubject(emailDTO.getAssunto().trim());
                }
                if (emailDTO.getTipoEnvio() == 2) {
                    msg = "Prezado(a) <b>" + emailDTO.getDestNome().trim() + "</b>,<br/> " + "&emsp;<b>" + emailDTO.getRemetNome().trim()
                            + "</b> está interessado no bolo <b>" + emailDTO.getNomeBolo().trim() + "</b> e lhe enviou uma mensagem.<br/><br/>"
                            + "----------- Mensagem -----------<br/>"
                            + emailDTO.getMensagem() + "<br/><br/> Telefone de Contato: " + emailDTO.getTelefone().trim() + "<br/>"
                            + "&emsp;<b><i>Enviado por BluCake</i></b><br/>";
                } else {
                    msg = "Novo interessado em ser Confeiteiro no BluCake!<br/><br/>"
                            + "Nome: <b>" + emailDTO.getRemetNome().trim() + "</b><br/>"
                            + "Email: " + emailDTO.getRemetEmail() + "<br/><br/>"
                            + "Entrar em contato para coletar mais informações!";
                }

                email.setMsg(msg);
                email.send();
            } catch (EmailException e) {
                System.err.println("EnviaEmail - Falha ao enviar email para: " + emailDTO.getDestEmail().trim()
                        + " | Erro: " + e.toString());
                return false;
            }
            
            

            return true;
        }
        return false;
    }
}
