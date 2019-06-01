/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blucake.api.repositorios;

import br.com.blucake.api.models.IngredienteReceita;
import br.com.blucake.api.models.Receita;
import br.com.blucake.api.models.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alunos
 */

@Repository
@Transactional(readOnly = true )
public interface ReceitaRepository extends JpaRepository <Receita, Long >{
    public Receita findByIngredienteReceitas ( List<IngredienteReceita> ing );
}
