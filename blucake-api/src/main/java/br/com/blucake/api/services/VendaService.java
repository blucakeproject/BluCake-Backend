package br.com.blucake.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blucake.api.models.Venda;
import br.com.blucake.api.models.Usuario;
import br.com.blucake.api.repositorios.VendaRepository;
import java.util.List;

@Service
public class VendaService{

	@Autowired
	private VendaRepository vendaRepository;
        
        public List<Venda> buscarTodasVendas(Usuario u){
            return this.vendaRepository.findAllByUsuario(u);
        }
        
        public Venda addVenda(Venda venda){            
            return this.vendaRepository.save(venda);       
        }
        
        public Optional<Venda> buscarPorId(Long id){
            return this.vendaRepository.findById(id);
        }
}
