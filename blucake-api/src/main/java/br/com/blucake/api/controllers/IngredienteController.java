/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blucake.api.controllers;

import br.com.blucake.api.models.Ingrediente;
import br.com.blucake.api.models.Response;
import br.com.blucake.api.services.IngredienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Leandro Prado
 */
@RestController
@RequestMapping("/ingrediente")
public class IngredienteController {
    
    
    @Autowired
    IngredienteService ingredienteService;
    
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public ResponseEntity<Response> buscarTodosIngredientes() {
        List<Ingrediente> list = ingredienteService.buscarTodosIngredientes();
        Response response = new Response(list);
        return ResponseEntity.ok().body(response);
    }
    
}