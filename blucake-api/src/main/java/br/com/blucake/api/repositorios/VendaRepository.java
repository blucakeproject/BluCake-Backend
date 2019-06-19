package br.com.blucake.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.blucake.api.models.Venda;
import br.com.blucake.api.models.Usuario;
import java.util.List;

@Repository
@Transactional(readOnly = true )
public interface VendaRepository extends JpaRepository <Venda, Long >{
 
}
