/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blucake.api.controllers;

import br.com.blucake.api.dto.ReceitaDTO;
import br.com.blucake.api.dto.UsuarioDTO;
import br.com.blucake.api.models.IngredienteReceita;
import br.com.blucake.api.models.Receita;
import br.com.blucake.api.models.Response;
import br.com.blucake.api.models.Usuario;
import br.com.blucake.api.services.IngredienteServiceImpl;
import br.com.blucake.api.services.ReceitaServiceImpl;
import br.com.blucake.api.services.UsuarioServiceImpl;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alunos
 */
@RestController
@RequestMapping("/receitas")
public class ReceitaController {
    @Autowired
    ReceitaServiceImpl receitaServiceImpl;
    @Autowired
    IngredienteServiceImpl ingredienteServiceImpl;
    
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public ResponseEntity<Response> buscarTodosUsuarios() {
        List<IngredienteReceita> ingredientesReceita = ingredienteServiceImpl.buscarPorIngredientes(ings)
        List<Receita> list = receitaServiceImpl.buscarPorIngredientes(ingredientesReceita);
        List<ReceitaDTO> listDto = list.stream().map(obj -> new ReceitaDTO(obj)).collect(Collectors.toList());
        Response response = new Response(listDto);
        return ResponseEntity.ok().body(response);
    }
}
