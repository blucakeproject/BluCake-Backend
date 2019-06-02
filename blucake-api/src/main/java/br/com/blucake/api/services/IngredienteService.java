/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blucake.api.services;

import br.com.blucake.api.models.Ingrediente;
import br.com.blucake.api.repositorios.IngrendienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leandro Prado
 */
@Service
public class IngredienteService {
    
    @Autowired
    IngrendienteRepository ingrendienteRepository;
    
     public List<Ingrediente> buscarTodosIngredientes(){
            return this.ingrendienteRepository.findAll();
        }
    
}
