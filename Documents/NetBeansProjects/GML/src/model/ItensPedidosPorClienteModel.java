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
    
    private String nomeDoProduto;
    private String cpf;
    private String categoria;
    private int desconto;
    private int idCategoria;
    private int quantidade;
    private float valor;
    private int quatidadeEmEstoque;
    private int idDoPedido;
    
    
    //CONSTRUTOR

    public ItensPedidosPorClienteModel() {
    }

    public ItensPedidosPorClienteModel(String nomeDoProduto, String cpf, String categoria, int idCategoria, int quantidade, int desconto, float valor) {
        this.nomeDoProduto = nomeDoProduto;
        this.cpf = cpf;
        this.categoria = categoria;
        this.idCategoria = idCategoria;
        this.quantidade = quantidade;
        this.desconto = desconto;
        this.valor = valor;
    }

    public ItensPedidosPorClienteModel(String nomeDoProduto, String categoria, int quantidade) {
        this.nomeDoProduto = nomeDoProduto;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }

    public ItensPedidosPorClienteModel(String cpf) {
        this.cpf = cpf;
    }

    public ItensPedidosPorClienteModel(String nomeDoProduto, String categoria) {
        this.nomeDoProduto = nomeDoProduto;
        this.categoria = categoria;
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

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    public int getQuatidadeEmEstoque() {
        return quatidadeEmEstoque;
    }

    public void setQuatidadeEmEstoque(int quatidadeEmEstoque) {
        this.quatidadeEmEstoque = quatidadeEmEstoque;
    }

    public int getIdDoPedido() {
        return idDoPedido;
    }

    public void setIdDoPedido(int idDoPedido) {
        this.idDoPedido = idDoPedido;
    }
    
    
}
