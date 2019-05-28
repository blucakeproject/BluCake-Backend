package br.com.blucake.api.repositorios;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.blucake.api.models.Usuario;
import java.util.List;

@Repository
@Transactional(readOnly = true )
public interface UsuarioRepository extends JpaRepository <Usuario, Long >{
    
        public List<Usuario> findAllByOrderByNome();

	public Usuario findByEmail ( String email );
}
