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
public class CadastrarProdutoModel {
    
    private String categoria;
    private String nomeDoProduto;
    private float valor;
    private int quantidade;
    
    //CONSTRUTOR

    public CadastrarProdutoModel(String categoria, String nomeDoProduto, float valor, int quantidade) {
        this.categoria = categoria;
        this.nomeDoProduto = nomeDoProduto;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public CadastrarProdutoModel() {
    }

    
    //GETTERS AND SETTERS

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categorio) {
        this.categoria = categorio;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
}
