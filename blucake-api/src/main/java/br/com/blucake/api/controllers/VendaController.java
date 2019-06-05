/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blucake.api.controllers;

import br.com.blucake.api.dto.VendaDTO;
import br.com.blucake.api.models.Venda;
import br.com.blucake.api.models.Response;
import br.com.blucake.api.services.VendaService;
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
 * @author Eder Jean Dias
 */

@RestController
@RequestMapping("/vendas")
public class VendaController {
    
     @Autowired
     VendaService vendaService;
    
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public ResponseEntity<Response> addUsuario(@RequestBody VendaDTO vendaDto) {
        Venda venda;
        venda = new Venda(vendaDto);
        VendaDTO vendaDTO = new VendaDTO(vendaService.addVenda(venda));
        Response response = new Response(vendaDTO);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public ResponseEntity<Response> addUsuario(@RequestBody VendaDTO vendaDto) {
        Venda venda;
        venda = new Venda(vendaDto);
        VendaDTO vendaDTO = new VendaDTO(vendaService.addVenda(venda));
        Response response = new Response(vendaDTO);
        return ResponseEntity.ok().body(response);
    }
    
    @DeleteMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public ResponseEntity<Response> addUsuario(@RequestBody VendaDTO vendaDto) {
        Venda venda;
        venda = new Venda(vendaDto);
        VendaDTO vendaDTO = new VendaDTO(vendaService.addVenda(venda));
        Response response = new Response(vendaDTO);
        return ResponseEntity.ok().body(response);
    }
}
