/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blucake.api.services;

import br.com.blucake.api.models.Receita;
import br.com.blucake.api.repositorios.ReceitaRepository;
import java.util.List;
import java.util.Optional;
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

    public List<Receita> buscarTodosReceitas() {
        return this.receitaRepository.findAll();
    }

    public Receita addReceita(Receita receita) {
        return this.receitaRepository.save(receita);
    }

    public void deletaReceita(Long id) {
        this.receitaRepository.deleteById(id);
    }

    public Optional<Receita> buscarReceitaPorId(Long id) {
        return this.receitaRepository.findById(id);
    }
}
