/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CaixaDao;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CaixaModel;
import view.CaixaCreditoView;
import view.CaixaDebitoView;
import view.CaixaDinheiroView;
import view.CaixaView;

/**
 *
 * @author topga
 */
public class CaixaController {
    
    private CaixaView view;

    public CaixaController(CaixaView view) {
        this.view = view;
    }
    
    public void listandoValoresDoBanco(){
       
        
        String cpf = view.getjTextFieldCpf().getText() +"%";
        
        CaixaModel model = new CaixaModel(cpf);
        DefaultTableModel tabela = (DefaultTableModel) view.getjTablePrincipal().getModel();

        try {
        
        Connection conecta = new Conexao().getConnection();
        CaixaDao dao = new CaixaDao(conecta);
        ArrayList<CaixaModel> lista = dao.retornandoOsValoresParaATabela(model);
        
        if ( lista != null){
            for (CaixaModel busca : lista){
                    tabela.addRow(new Object[]{
                    busca.getIdDoPedido(),
                    busca.getCliente(),
                    busca.getProduto(),
                    busca.getQuantidade(),
                    busca.getValor()
                });       
            }      
        }
        
        
        
        } catch (SQLException ex) {
            Logger.getLogger(ListarProdutosPorClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(view, "Erro no metodo listandoValoresDoBanco \n" + ex);
        }
        
    }
    
    public void acessandoAsClassesDoCaixa(){
        
        if(view.getjRadioButtonDebito().isSelected()){
            CaixaDebitoView debito = new CaixaDebitoView();
            debito.setVisible(true);
            
        }else if(view.getjRadioButtonDinheiro().isSelected()){
            CaixaDinheiroView dinheiro = new CaixaDinheiroView();
            dinheiro.setVisible(true);
            
        }else if (view.getjRadioButtonCredito().isSelected()){
            CaixaCreditoView credito = new CaixaCreditoView();
            credito.setVisible(true);
        }
            
    }
    
}
