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
public class CaixaDinheiroModel {
    
    private int idDoPedido;
    private String nomeDoCliente;
    private String nomeDoProduto;
    private int quantidade;
    private float valor;
    private int desconto;
    private float valorTotal;
   
    private int id_caixa;
    private String status;
   
   
   //CONSTRUTOR

    public CaixaDinheiroModel() {
    }

    public CaixaDinheiroModel(int idDoPedido) {
        this.idDoPedido = idDoPedido;
    }

    public CaixaDinheiroModel(int idDoPedido, float valorTotal, int id_caixa, String status) {
        this.idDoPedido = idDoPedido;
        this.valorTotal = valorTotal;
        this.id_caixa = id_caixa;
        this.status = status;
    }
    
   //GETTERS AND SETTERS

    public int getIdDoPedido() {
        return idDoPedido;
    }

    public void setIdDoPedido(int idDoPedido) {
        this.idDoPedido = idDoPedido;
    }

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
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

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getId_caixa() {
        return id_caixa;
    }

    public void setId_caixa(int id_caixa) {
        this.id_caixa = id_caixa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   
 
}
