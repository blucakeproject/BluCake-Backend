package br.com.blucake.api.repositorios;

import br.com.blucake.api.models.Receita;
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
public interface ReceitaRepository extends JpaRepository <Receita, Long >{
    public List<Receita> findAllByOrderByPreco();
    public List<Receita> findAllByOrderByPrecoDesc(); 
}