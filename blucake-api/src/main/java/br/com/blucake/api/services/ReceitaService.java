/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blucake.api.services;

import br.com.blucake.api.models.Receita;
import br.com.blucake.api.models.Usuario;
import br.com.blucake.api.repositorios.ReceitaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leandro Prado
 */
@Service
public class ReceitaService {
    
    @Autowired
    ReceitaRepository receitaRepository;
    
     public List<Receita> buscarTodosReceitas(){
            return this.receitaRepository.findAll();
        }
     
     public Receita buscaReceitaPorId(Long id){
         return this.receitaRepository.findById(id).get();
     }
     
     public List<Receita> buscaReceitaPorUsuario(Usuario usuario){
         return this.receitaRepository.findByUsuario(usuario);
     }
     
     public Receita cadastroDeReceita(Receita receita){
         return this.receitaRepository.save(receita);
     }
}
