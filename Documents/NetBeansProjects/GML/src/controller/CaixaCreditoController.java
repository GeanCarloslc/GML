/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CaixaCreditoDao;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.CaixaCreditoModel;
import view.CaixaCreditoView;

/**
 *
 * @author topga
 */
public class CaixaCreditoController {
    
    private final CaixaCreditoView view;

    public CaixaCreditoController(CaixaCreditoView view) {
        this.view = view;
    }
    
    public void buscandoDadosDoBancoUtilizandoOIdCliente(){
        
        int idDoPedido = Integer.parseInt(view.getjTextFieldIdDoPedido().getText());

        CaixaCreditoModel model = new CaixaCreditoModel(idDoPedido);
         
        try {
            Connection conecta = new Conexao().getConnection();
            CaixaCreditoDao dao = new CaixaCreditoDao(conecta);
            ArrayList<CaixaCreditoModel> lista = dao.buscandoDadosDoPedido(model);
            
            for (CaixaCreditoModel busca : lista) {
                view.getjTextFieldNomeDoCliente().setText(view.getjTextFieldNomeDoCliente().getText() + busca.getNomeDoCliente());
                view.getjTextFieldNomeDoProduto().setText(view.getjTextFieldNomeDoProduto().getText() + busca.getNomeDoProduto());
                view.getjTextFieldQuantidade().setText(view.getjTextFieldQuantidade().getText() + busca.getQuantidade());
                view.getjTextFieldValorUnitarioDoProduto().setText(view.getjTextFieldValorUnitarioDoProduto().getText() + busca.getValor());
                view.getjTextFieldDesconto().setText(view.getjTextFieldDesconto().getText() + busca.getDesconto());      
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CaixaDebitoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    public void operacoesMatematicas(){
        
        int quantidade = Integer.parseInt(view.getjTextFieldQuantidade().getText());
        float desconto = Float.parseFloat(view.getjTextFieldDesconto().getText());
        float valorUnitario = Float.parseFloat(view.getjTextFieldValorUnitarioDoProduto().getText());
        float valor;
        
        desconto = desconto / 100; // %

        valor = valorUnitario * quantidade;
        
        float valorFinal = valor - (desconto * valor);
        
        String ValorFinalString = Float.toString(valorFinal);
        
        view.getjTextFieldTotal().setText(ValorFinalString);
          
        
    }
    
    public void utiliandoOInsert(){
        
        int idCaixaDebito = 1;
        String status = "Encerrada";
        int idDoPedido = Integer.parseInt(view.getjTextFieldIdDoPedido().getText());
        float valorTotal = Float.parseFloat(view.getjTextFieldTotal().getText());
        int parcelas = Integer.parseInt(view.getjTextFieldParcelas().getText());
        
        CaixaCreditoModel model = new CaixaCreditoModel(idDoPedido, valorTotal, idCaixaDebito, status, parcelas);
        
        try {
            
        Connection conecta = new Conexao().getConnection();
        CaixaCreditoDao dao = new CaixaCreditoDao(conecta);
        dao.utilizandoOInsert(model);
        JOptionPane.showMessageDialog(view, "Pedido encerrado!");
        
        } catch (SQLException ex) {
            Logger.getLogger(CaixaDebitoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    
}
