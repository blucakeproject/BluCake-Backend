/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blucake.api.repositorios;

import br.com.blucake.api.models.Ingrediente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Leandro Prado
 */
@Repository
@Transactional(readOnly = true )
public interface IngrendienteRepository extends JpaRepository <Ingrediente, Long >{
    
    public List<Ingrediente> findAllByOrderByNome(); 
    
}
