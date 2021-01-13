/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CaixaDinheiroDao;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.CaixaDinheiroModel;
import view.CaixaDinheiroView;

/**
 *
 * @author topga
 */
public class CaixaDinheiroController {
    
    private final CaixaDinheiroView view;

    public CaixaDinheiroController(CaixaDinheiroView view) {
        this.view = view;
    }
    
    public void buscandoDadosDoBancoUtilizandoOIdCliente(){
        
        int idDoPedido = Integer.parseInt(view.getjTextFieldIdDoPedido().getText());

        CaixaDinheiroModel model = new CaixaDinheiroModel(idDoPedido);
         
        try {
            Connection conecta = new Conexao().getConnection();
            CaixaDinheiroDao dao = new CaixaDinheiroDao(conecta);
            ArrayList<CaixaDinheiroModel> lista = dao.buscandoDadosDoPedido(model);
            
            for (CaixaDinheiroModel busca : lista) {
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
        
        int idCaixaDebito = 2;
        String status = "Encerrada";
        int idDoPedido = Integer.parseInt(view.getjTextFieldIdDoPedido().getText());
        float valorTotal = Float.parseFloat(view.getjTextFieldTotal().getText());
        
        CaixaDinheiroModel model = new CaixaDinheiroModel(idDoPedido, valorTotal, idCaixaDebito, status);
        
        try {
            
        Connection conecta = new Conexao().getConnection();
        CaixaDinheiroDao dao = new CaixaDinheiroDao(conecta);
        dao.utilizandoOInsert(model);
        JOptionPane.showMessageDialog(view, "Pedido encerrado!");
        
        } catch (SQLException ex) {
            Logger.getLogger(CaixaDebitoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    
}
