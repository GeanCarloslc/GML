/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Conexao;
import dao.ItensPedidosPorClienteDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ItensPedidosPorClienteModel;
import view.ItensPedidosPorClienteView;

/**
 *
 * @author topga
 */
public class ItensPedidosPorClienteController {
    
    private final ItensPedidosPorClienteView view;

    public ItensPedidosPorClienteController(ItensPedidosPorClienteView view) {
        this.view = view;
    }
    
    public void inserindoDadosEUtilizandoOUpdate(){
        
       
        if (view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("<Selecione uma categoria>")){
            JOptionPane.showMessageDialog(view, "Selecione uma categoria");
               
                
      
 
        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Smartphones")){
            
            String nomeDoProduto = view.getjTextFieldNomeDoProduto().getText();
            String cpf = view.getjTextFieldCpf().getText();
            String categoria = view.getjComboBoxSeletorDeCategoria().getSelectedItem().toString();
            int quantidade = Integer.parseInt(view.getjTextFieldQuantidade().getText());
            int idCategoria = 1;
            float valor = Float.parseFloat(view.getjTextFieldValor().getText());
            
            // Utilizado o (model) para realizar o set das informações do metodo updateDiminuindoAQuantidadeDaEntidadeCategoria
            ItensPedidosPorClienteModel model = new ItensPedidosPorClienteModel(nomeDoProduto, categoria, quantidade);
            // Utilizado o (model2) para realizar o set das informações do metodo updateDiminuindoAQuantidadeDaEntidadeCategoria
            ItensPedidosPorClienteModel model2 = new ItensPedidosPorClienteModel(nomeDoProduto, cpf, categoria, idCategoria, quantidade, valor);
            
            
            try {
                
                Connection conecta = new Conexao().getConnection();
                ItensPedidosPorClienteDao dao = new ItensPedidosPorClienteDao(conecta);
                dao.updateDiminuindoAQuantidadeDaEntidadeCategoria(model);
                dao.insertNaTabelaItensPorClientes(model2);
                
            } catch (SQLException ex) {
                Logger.getLogger(ItensPedidosPorClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            

                
            
            

        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Acessorios")){
            
                
            
            
        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Hardwares")){
                
                
            
            
        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Consoles")){
            
                
            
 
        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Jogos")){
            
                
        
            
        }
        
        
    }
    
    
    
    
}
