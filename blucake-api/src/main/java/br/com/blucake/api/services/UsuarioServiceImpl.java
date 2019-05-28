package br.com.blucake.api.services;

import br.com.blucake.api.dto.UsuarioDTO;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blucake.api.models.Usuario;
import br.com.blucake.api.repositorios.UsuarioRepository;
import java.util.List;

@Service
public class UsuarioServiceImpl implements  UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Optional<Usuario> buscarPorEmail(String email) {
		return Optional.ofNullable(this.usuarioRepository.findByEmail(email));
	}
        
        public List<Usuario> buscarTodosUsuarios(){
            return this.usuarioRepository.findAllByOrderByNome();
        }
        
        public Usuario addUsuario(Usuario user){            
            return this.usuarioRepository.save(user);       
        }
}
