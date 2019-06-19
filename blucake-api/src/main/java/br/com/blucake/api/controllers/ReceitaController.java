/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blucake.api.controllers;

import br.com.blucake.api.dto.ReceitaDTO;
import br.com.blucake.api.models.Ingrediente;
import br.com.blucake.api.models.Receita;
import br.com.blucake.api.models.Response;
import br.com.blucake.api.services.IngredienteService;
import br.com.blucake.api.services.ReceitaService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
     
     @Autowired
     IngredienteService ingredienteService;
    
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public ResponseEntity<Response> buscarTodasReceitas() {
        List<Receita> list = receitaService.buscarTodosReceitas();
        Response response = new Response(list);
        return ResponseEntity.ok().body(response);
    }
    
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    @RequestMapping("/receitaporid")
    public ResponseEntity<Response> buscarReceitaPorId(@RequestBody Long id) {
        Optional<Receita> receita = receitaService.buscarReceitaPorId(id);
        Response response = new Response(receita);
        return ResponseEntity.ok().body(response);
    }
    
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public ResponseEntity<Response> adicionaReceita(@RequestBody ReceitaDTO receitaDTO) {
        Receita receita = new Receita(receitaDTO);        
        Response response = new Response(receitaService.addReceita(receita));
        return ResponseEntity.ok().body(response);
    }
    
    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public ResponseEntity<Response> editaReceita(@RequestBody ReceitaDTO receitaDTO) {
        Receita receita = new Receita(receitaDTO);
        Response response = new Response(receitaService.addReceita(receita));
        return ResponseEntity.ok().body(response);
    }
    
    @DeleteMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public String deletaReceita(@RequestBody Long id) {
        receitaService.deletaReceita(id);
        return "ok";
    }
}
