package br.com.blucake.api.controllers;

import br.com.blucake.api.dto.EnviaEmailDTO;
import br.com.blucake.api.dto.UsuarioDTO;
import br.com.blucake.api.models.Response;
import br.com.blucake.api.models.Usuario;
import br.com.blucake.api.services.UsuarioServiceImpl;
import br.com.blucake.api.utils.EnviaEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lucas Jansen
 */
@RestController
@RequestMapping("/enviaEmail")
public class EnviaEmailController {

    @Autowired
    UsuarioServiceImpl usuarioServiceImpl;

    @Autowired
    EnviaEmail enviaEmail;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public ResponseEntity<Response> enviarEmail(@RequestBody EnviaEmailDTO email) {
        Response response = new Response(enviaEmail.enviar(email));
        return ResponseEntity.ok().body(response);
    }
}
