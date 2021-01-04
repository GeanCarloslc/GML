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
public class ListarProdutosDoEstoqueModel {
    
    
    private int id; 
    private String nomeDoProduto;
    private String categoria;
    private float valor;
    private int quantidade;
    
    
    //CONSTRUTOR

    public ListarProdutosDoEstoqueModel(String categoria) {
        this.categoria = categoria;
    }
    
    public ListarProdutosDoEstoqueModel(String nomeDoProduto, String categoria) {
        this.nomeDoProduto = nomeDoProduto;
        this.categoria = categoria;
    }
    
    public ListarProdutosDoEstoqueModel() {
    }
    
    //GETTERS AND SETTERS

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
