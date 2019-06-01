/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blucake.api.services;

import br.com.blucake.api.models.Ingrediente;
import br.com.blucake.api.models.IngredienteReceita;
import java.util.List;
import java.util.Optional;
import br.com.blucake.api.repositorios.IngredientaReceitaRepository;

/**
 *
 * @author Alunos
 */
public class IngredienteServiceImpl implements IngredienteService{
    private IngredientaReceitaRepository ingredientaReceitaRepository;

    @Override
    public Optional<IngredienteReceita> buscarPorIngredientes(List<Ingrediente> ings) {
        return Optional.ofNullable(this.ingredientaReceitaRepository.findByIngrediente(ings));
    }

    
}
