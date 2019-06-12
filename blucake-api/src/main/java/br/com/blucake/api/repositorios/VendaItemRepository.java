package br.com.blucake.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.blucake.api.models.VendaItem;

@Repository
@Transactional(readOnly = true )
public interface VendaItemRepository extends JpaRepository <VendaItem, Long >{
 
}
