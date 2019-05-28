package br.com.blucake.api.services;

import java.util.Optional;

import br.com.blucake.api.models.Usuario;

public interface UsuarioService {

	/**
	* Busca e retorna um usuário dado um email.
	*
	* @param email
	* @return Optional<Usuario>
	*/
	Optional <Usuario> buscarPorEmail(String email);
}
