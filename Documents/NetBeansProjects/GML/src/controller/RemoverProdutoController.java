/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Conexao;
import dao.RemoverProdutoDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.RemoverProdutoModel;
import view.RemoverProdutoView;

/**
 *
 * @author topga
 */
public class RemoverProdutoController {
    
    private RemoverProdutoView view;

    public RemoverProdutoController(RemoverProdutoView view) {
        this.view = view;
    }
    
    public void listandoDadosNaJtable(){
        
        
        String categoria = view.getjComboBoxSeletorDeCategoria().getSelectedItem().toString();
        RemoverProdutoModel model = new RemoverProdutoModel(categoria);
        
        DefaultTableModel tabela = (DefaultTableModel) view.getjTableResultSet().getModel();
        
        if(categoria.equals("<Selecione uma categoria>")){
            JOptionPane.showMessageDialog(view, "Selecione uma categoria");
        }else{
        
        try {
            
            Connection conecta = new Conexao().getConnection();
            RemoverProdutoDao dao = new RemoverProdutoDao(conecta);
            ArrayList<RemoverProdutoModel> lista = dao.utilizandoOResultSet(model);
            
            for(RemoverProdutoModel busca : lista){
                tabela.addRow(new Object[]{
                    busca.getIdDoProduto(),
                    busca.getNomeDoProduto(),
                    busca.getCategoria(),
                    busca.getValor(),
                    busca.getQuantidade()    
                });
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RemoverProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
            
    }
    
}
