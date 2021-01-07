/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author topga
 */
public class ItensPedidosPorClienteModel {
    
    String nomeDoProduto;
    String cpf;
    String categoria;
    int idCategoria;
    int quantidade;
    float valor;
    
    //CONSTRUTOR

    public ItensPedidosPorClienteModel() {
    }

    public ItensPedidosPorClienteModel(String nomeDoProduto, String cpf, String categoria, int idCategoria, int quantidade, float valor) {
        this.nomeDoProduto = nomeDoProduto;
        this.cpf = cpf;
        this.categoria = categoria;
        this.idCategoria = idCategoria;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public ItensPedidosPorClienteModel(String nomeDoProduto, String categoria, int quantidade) {
        this.nomeDoProduto = nomeDoProduto;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }

    
     
    //GETTERS AND SETTERS

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    
}
