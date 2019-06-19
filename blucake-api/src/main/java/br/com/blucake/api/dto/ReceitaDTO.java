/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blucake.api.dto;

import br.com.blucake.api.models.EmailEnviado;
import br.com.blucake.api.models.Ingrediente;
import br.com.blucake.api.models.Receita;
import br.com.blucake.api.models.Usuario;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alunos
 */
public class ReceitaDTO {
    private long receita_id;

    private String nome;

    private String descricao;

    private Double preco;

    private String imagem;

    private Date dataCadastro;

    public ReceitaDTO(long receita_id, String nome, String descricao, Double preco, String imagem, Date dataCadastro, List<Ingrediente> ingrediente, List<EmailEnviado> emailEnviados, Usuario usuario) {
        this.receita_id = receita_id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imagem = imagem;
        this.dataCadastro = dataCadastro;
    }

     public ReceitaDTO(Receita obj) {
        this.receita_id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
        this.preco = obj.getPreco();
        this.imagem = obj.getImagem();
        this.dataCadastro = obj.getDataCadastro();
    }
    
    public long getReceita_id() {
        return receita_id;
    }

    public void setReceita_id(long receita_id) {
        this.receita_id = receita_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }    
}
