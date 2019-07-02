/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blucake.api.controllers;

import br.com.blucake.api.dto.UsuarioDTO;
import br.com.blucake.api.models.Receita;
import br.com.blucake.api.models.Response;
import br.com.blucake.api.models.Usuario;
import br.com.blucake.api.services.ReceitaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Leandro Prado
 */

@RestController
@RequestMapping("/receitas")
public class ReceitaController {
    
     @Autowired
     ReceitaService receitaService;
    
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    @RequestMapping("/todos")
    public ResponseEntity<Response> buscarTodasReceitas() {
        List<Receita> list = receitaService.buscarTodosReceitas();
        Response response = new Response(list);
        return ResponseEntity.ok().body(response);
    }
    
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    @RequestMapping("/porUsuario")
    public ResponseEntity<Response> buscarReceitaPorUsuario(@RequestBody Usuario usu) {
        List<Receita> lista = receitaService.buscaReceitaPorUsuario(usu);
        Response response = new Response(lista);
        return ResponseEntity.ok().body(response);
    }
    
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    @RequestMapping("/cadastro")
    public ResponseEntity<Response> cadastroDeReceita(@RequestBody Receita receita) {
        Receita recei = receitaService.cadastroDeReceita(receita);
        Response response = new Response(recei);
        return ResponseEntity.ok().body(response);
    }
}
