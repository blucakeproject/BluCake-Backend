/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blucake.api.services;

import br.com.blucake.api.models.Ingrediente;
import br.com.blucake.api.repositorios.IngrendienteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.SQLWarningException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leandro Prado
 */
@Service
public class IngredienteService {

    @Autowired
    IngrendienteRepository ingrendienteRepository;

    public List<Ingrediente> buscarTodosIngredientes() {
        return this.ingrendienteRepository.findAllByOrderByNome();
    }

    public Boolean remover(Long id) {
        try {
            this.ingrendienteRepository.deleteById(id);
        } catch (SQLWarningException e) {
            System.out.println("Erro ao Deletar Ingrediente: " + e);
            return false;
        }
        return true;
    }

    public Boolean addIngrediente(Ingrediente ingrediente) {
        return this.ingrendienteRepository.save(ingrediente) != null;
    }

    public Optional<Ingrediente> buscarPorId(Long id) {
        return this.ingrendienteRepository.findById(id);
    }

}
