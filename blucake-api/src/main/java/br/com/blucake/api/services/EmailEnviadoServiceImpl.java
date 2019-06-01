package br.com.blucake.api.services;

import br.com.blucake.api.models.EmailEnviado;
import br.com.blucake.api.models.Usuario;
import br.com.blucake.api.repositorios.EmailEnviadoRepository;
import br.com.blucake.api.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lucas
 */
@Service
public class EmailEnviadoServiceImpl {

    @Autowired
    private EmailEnviadoRepository emailEnviadoRepository;

    public EmailEnviado gravaEmailEnviado(EmailEnviado emailEnviado) {
        return this.emailEnviadoRepository.save(emailEnviado);
    }
}
