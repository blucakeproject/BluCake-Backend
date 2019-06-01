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

/**
 *
 * @author Alunos
 */
public interface IngredienteService {
     Optional <IngredienteReceita> buscarPorIngredientes(List<Ingrediente> ings);
}
