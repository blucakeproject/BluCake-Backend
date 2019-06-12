/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blucake.api.controllers;

import br.com.blucake.api.dto.IngredienteDTO;
import br.com.blucake.api.models.Ingrediente;
import br.com.blucake.api.models.Response;
import br.com.blucake.api.services.IngredienteService;
import java.util.List;
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

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public ResponseEntity<Response> addIngrediente(@RequestBody IngredienteDTO ingrDto) {
        Ingrediente ingrediente = new Ingrediente(ingrDto);
        Boolean adicionou = ingredienteService.addIngrediente(ingrediente);

        ingrediente = null;
        if (adicionou) {
            ingrediente = ingredienteService.buscarPorNome(ingrDto.getNome());
            if (ingrediente == null) {
                adicionou = false;
            }
        }
        return ResponseEntity.ok().body(new Response(adicionou));
    }

//    @PutMapping
//    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
//    public ResponseEntity<Response> alterarIngrediente(@RequestBody IngredienteDTO ingrDto) {
////        
////        Boolean alterou = false;
////        if (ingrDto != null) {
////            Ingrediente oriIngrediente = ingredienteService.buscarPorId(ingrDto.getId());
////            
////            Ingrediente ingrediente = new Ingrediente(ingrDto);
////            ingredienteService.alterarIngrediente(ingrediente);
////            
////            ingrediente = ingredienteService.buscarPorNome(ingrDto.getNome());
////            if (!ingrediente.getNome().equalsIgnoreCase(oriIngrediente.getNome())) {
////                alterou = true;
////            }
////        }
////        return ResponseEntity.ok().body(new Response(alterou));
//    }

    @DeleteMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public ResponseEntity<Response> deletarIngrediente(@RequestBody IngredienteDTO ingrDto) {
        Boolean deletou = false;
        if (ingrDto.getId() != null) {
            ingredienteService.remover(ingrDto.getId());

            deletou = !ingredienteService.buscarPorId(ingrDto.getId()).isPresent();
        }
        return ResponseEntity.ok().body(new Response(deletou));
    }

}
