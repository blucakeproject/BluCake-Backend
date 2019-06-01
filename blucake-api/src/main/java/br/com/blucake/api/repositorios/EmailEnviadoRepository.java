package br.com.blucake.api.repositorios;

import br.com.blucake.api.models.EmailEnviado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Lucas
 */
@Repository
@Transactional(readOnly = true)
public interface EmailEnviadoRepository extends JpaRepository<EmailEnviado, Long> {
    
}
