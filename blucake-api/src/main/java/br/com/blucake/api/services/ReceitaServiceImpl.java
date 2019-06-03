package br.com.blucake.api.services;

import br.com.blucake.api.models.Receita;
import br.com.blucake.api.models.Usuario;
import br.com.blucake.api.repositorios.ReceitaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lucas Jansen
 */
@Service
public class ReceitaServiceImpl {

    @Autowired
    private ReceitaRepository receitaRepository;

    public Receita addReceita(Receita receita) {
        return this.receitaRepository.save(receita);
    }

    public Optional<Receita> buscarPorId(Long id) {
        return this.receitaRepository.findById(id);
    }
}
