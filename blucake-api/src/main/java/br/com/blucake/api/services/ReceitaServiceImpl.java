/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blucake.api.services;

import br.com.blucake.api.models.IngredienteReceita;
import br.com.blucake.api.models.Receita;
import br.com.blucake.api.repositorios.ReceitaRepository;
import br.com.blucake.api.repositorios.UsuarioRepository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Alunos
 */
public class ReceitaServiceImpl implements ReceitaService {
    
    private ReceitaRepository receitaRepository;

    @Override
    public Optional<Receita> buscarPorIngredientes(List<IngredienteReceita> ingredientesReceita) {
        return Optional.ofNullable(this.receitaRepository.findByIngredienteReceitas(ingredientesReceita));
    }
    
}
