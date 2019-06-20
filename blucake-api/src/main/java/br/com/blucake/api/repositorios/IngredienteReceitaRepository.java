/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blucake.api.repositorios;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alunos
 */
@Repository
@Transactional(readOnly = true )
public interface IngredienteReceitaRepository extends JpaRepository <IgrendienteReceita, Long >{
    
}
