package br.com.blucake.api.utils;

import br.com.blucake.api.dto.EnviaEmailDTO;
import br.com.blucake.api.models.EmailEnviado;
import br.com.blucake.api.models.Usuario;
import br.com.blucake.api.services.EmailEnviadoServiceImpl;
import br.com.blucake.api.services.UsuarioServiceImpl;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lucas
 */
@Service
public class EnviaEmail {

    @Autowired
    private EmailEnviadoServiceImpl emailEnviadoService;

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    private final String smtp = "smtp.gmail.com";
    private final String portaSmtp = "587";
    private final String usuarioSmtp = "projetoblucake@gmail.com";
    private final String senhaUsuarioSmtp = "blucake2019";
    private final DefaultAuthenticator autenticador = new DefaultAuthenticator(usuarioSmtp, senhaUsuarioSmtp);
    private final SimpleEmail email = new SimpleEmail();

    private String msg;
    private String assunto;

    public EnviaEmail() {
        
    }

    private boolean validaEnvio(EnviaEmailDTO emailDTO) {
        if (emailDTO == null) {
            return false;
        } else if (emailDTO.getTipoEnvio() == 1) {
            return !(emailDTO.getRemetEmail().trim().isEmpty() || emailDTO.getRemetNome().trim().isEmpty());
        }
        return !(emailDTO.getDestEmail().trim().isEmpty() || emailDTO.getDestNome().trim().isEmpty()
                || emailDTO.getRemetEmail().trim().isEmpty() || emailDTO.getRemetNome().trim().isEmpty()
                || emailDTO.getMensagem().trim().isEmpty());
    }

    public boolean enviar(EnviaEmailDTO emailDTO) {

        if (validaEnvio(emailDTO)) {
            try {
                email.setHostName(smtp);
                email.setSmtpPort(Integer.getInteger(portaSmtp));
                email.setAuthenticator(autenticador);
                email.setTLS(true);
                if (emailDTO.getTipoEnvio() == 1) {
                    email.setFrom(usuarioSmtp);
                    assunto = "Solicitação de Cadastro de Novo Confeiteiro";

                    msg = "Novo interessado em ser Confeiteiro no BluCake!<br/><br/>"
                            + "Nome: <b>" + emailDTO.getRemetNome().trim() + "</b><br/>"
                            + "Email: " + emailDTO.getRemetEmail() + "<br/><br/>"
                            + "Entrar em contato para coletar mais informações!";
                } else {
                    email.setFrom(emailDTO.getDestEmail().trim());
                    assunto = emailDTO.getRemetNome().trim() + " - Novo Interessado";

                    msg = "Prezado(a) <b>" + emailDTO.getDestNome().trim() + "</b>,<br/> " + "&emsp;<b>" + emailDTO.getRemetNome().trim()
                            + "</b> está interessado no bolo <b>" + emailDTO.getNomeBolo().trim() + "</b> e lhe enviou uma mensagem.<br/><br/>"
                            + "----------- Mensagem -----------<br/>"
                            + emailDTO.getMensagem() + "<br/><br/> Telefone de Contato: " + emailDTO.getTelefone().trim() + "<br/>"
                            + "&emsp;<b><i>Enviado por BluCake</i></b><br/>";
                }

                email.addTo(emailDTO.getRemetEmail().trim());
                email.setSubject(assunto);
                email.setMsg(msg);
                email.send();
            } catch (EmailException e) {
                System.err.println("EnviaEmail - Falha ao enviar email para: " + emailDTO.getDestEmail().trim()
                        + " | Erro: " + e.toString());
                gravaEnvio(emailDTO.getIdUsuario());
                return false;
            }

            return true;
        }
        return false;
    }

    private void gravaEnvio(Long usuarioId) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Calendar calendar = Calendar.getInstance();

        EmailEnviado emailEnviado = new EmailEnviado(null,
                email.getHostName(),
                email.getSubject(),
                smtp, smtp, 0, smtp, smtp, assunto, msg, true, usuarioId, calendar.getTime());

        emailEnviadoService.gravaEmailEnviado(emailEnviado);
    }
}
