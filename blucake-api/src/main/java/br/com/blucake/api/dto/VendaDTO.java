package br.com.blucake.api.dto;

import br.com.blucake.api.models.Usuario;
import br.com.blucake.api.models.Venda;
import br.com.blucake.api.models.VendaItem;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Eder Jean Dias
 */
public class VendaDTO {

    private Long id;

    private String descricao;

    private Date dataVenda;

    private String nomeVendedor;

    private Double valorTotal;
    
    private Usuario usuario;
    
    private List<VendaItem> itensVenda;

    public VendaDTO() {
    }

    public VendaDTO(Long id, String descricao, Date dataVenda, String nomeVendedor, Double valorTotal, Usuario usuario, List<VendaItem> itensVenda) {
        this.id = id;
        this.descricao = descricao;
        this.dataVenda = dataVenda;
        this.nomeVendedor = nomeVendedor;
        this.valorTotal = valorTotal;
        this.usuario = usuario;
        this.itensVenda = itensVenda;
    }
    
    public VendaDTO(Venda obj) {
        this.id = id;
        this.descricao = descricao;
        this.dataVenda = dataVenda;
        this.nomeVendedor = nomeVendedor;
        this.valorTotal = valorTotal;
        this.usuario = usuario;
        this.itensVenda = itensVenda;
    }
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<VendaItem> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<VendaItem> itensVenda) {
        this.itensVenda = itensVenda;
    }
    
    
    
    



}
