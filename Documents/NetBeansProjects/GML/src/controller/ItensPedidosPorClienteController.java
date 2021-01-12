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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
    
    public void utilizandoOInsert(){
        
            String nomeDoProduto = view.getjTextFieldNomeDoProduto().getText();
            String cpf = view.getjTextFieldCpf().getText();
            String categoria = view.getjComboBoxSeletorDeCategoria().getSelectedItem().toString();
            int quantidade = Integer.parseInt(view.getjTextFieldQuantidade().getText());
            int desconto = Integer.parseInt(view.getjTextFieldDesconto().getText());
            float valor = Float.parseFloat(view.getjTextFieldValor().getText());
                  
        if (view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("<Selecione uma categoria>")){
            JOptionPane.showMessageDialog(view, "Selecione uma categoria");
               
        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Smartphones")){
            
            int idCategoria = 1;
           
            // Utilizado o (model2) para realizar o set das informações do metodo insertNaTabelaItensPorClientes
            ItensPedidosPorClienteModel model2 = new ItensPedidosPorClienteModel(nomeDoProduto, cpf, categoria, idCategoria, quantidade, desconto, valor);
             
            try {
                
                Connection conecta = new Conexao().getConnection();
                ItensPedidosPorClienteDao dao = new ItensPedidosPorClienteDao(conecta);
                dao.insertNaTabelaItensPorClientes(model2);
                JOptionPane.showMessageDialog(view, "Produto reservado com sucesso!");
                  
            } catch (SQLException ex) {
                Logger.getLogger(ItensPedidosPorClienteController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, "Erro no metodo utilizandoOInsert: \n" + ex);
            }
    
        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Acessorios")){
            
            int idCategoria = 2;
              
            // Utilizado o (model2) para realizar o set das informações do metodo insertNaTabelaItensPorClientes
            ItensPedidosPorClienteModel model2 = new ItensPedidosPorClienteModel(nomeDoProduto, cpf, categoria, idCategoria, quantidade, desconto, valor);
             
            try {
                
                Connection conecta = new Conexao().getConnection();
                ItensPedidosPorClienteDao dao = new ItensPedidosPorClienteDao(conecta);
                dao.insertNaTabelaItensPorClientes(model2);
                JOptionPane.showMessageDialog(view, "Produto reservado com sucesso!");
                  
            } catch (SQLException ex) {
                Logger.getLogger(ItensPedidosPorClienteController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, "Erro no metodo utilizandoOInsert: \n" + ex);
            }
            
            
        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Hardwares")){
            
            int idCategoria = 3;   
             
            // Utilizado o (model2) para realizar o set das informações do metodo insertNaTabelaItensPorClientes
            ItensPedidosPorClienteModel model2 = new ItensPedidosPorClienteModel(nomeDoProduto, cpf, categoria, idCategoria, quantidade, desconto, valor);
             
            try {
                
                Connection conecta = new Conexao().getConnection();
                ItensPedidosPorClienteDao dao = new ItensPedidosPorClienteDao(conecta);
                dao.insertNaTabelaItensPorClientes(model2);
                JOptionPane.showMessageDialog(view, "Produto reservado com sucesso!");
                  
            } catch (SQLException ex) {
                Logger.getLogger(ItensPedidosPorClienteController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, "Erro no metodo utilizandoOInsert: \n" + ex);
            }
            
            
        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Consoles")){
            
            int idCategoria = 4;    
            
            // Utilizado o (model2) para realizar o set das informações do metodo insertNaTabelaItensPorClientes
            ItensPedidosPorClienteModel model2 = new ItensPedidosPorClienteModel(nomeDoProduto, cpf, categoria, idCategoria, quantidade, desconto, valor);
             
            try {
                
                Connection conecta = new Conexao().getConnection();
                ItensPedidosPorClienteDao dao = new ItensPedidosPorClienteDao(conecta);
                dao.insertNaTabelaItensPorClientes(model2);
                JOptionPane.showMessageDialog(view, "Produto reservado com sucesso!");
                  
            } catch (SQLException ex) {
                Logger.getLogger(ItensPedidosPorClienteController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, "Erro no metodo utilizandoOInsert: \n" + ex);
            }
 
        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Jogos")){
            
            int idCategoria = 5;    
            
            // Utilizado o (model2) para realizar o set das informações do metodo insertNaTabelaItensPorClientes
            ItensPedidosPorClienteModel model2 = new ItensPedidosPorClienteModel(nomeDoProduto, cpf, categoria, idCategoria, quantidade, desconto, valor);
             
            try {
                
                Connection conecta = new Conexao().getConnection();
                ItensPedidosPorClienteDao dao = new ItensPedidosPorClienteDao(conecta);
                dao.insertNaTabelaItensPorClientes(model2);
                JOptionPane.showMessageDialog(view, "Produto reservado com sucesso!");
                  
            } catch (SQLException ex) {
                Logger.getLogger(ItensPedidosPorClienteController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, "Erro no metodo utilizandoOInsert: \n" + ex);
            }
            
        }
        
        
    }
    
    public void listandoValoresDoBancoNoBotaoBuscar(){
        
        String nomeDoProduto = view.getjTextFieldNomeDoProduto().getText();
        String categoria = view.getjComboBoxSeletorDeCategoria().getSelectedItem().toString();
        ItensPedidosPorClienteModel model = new ItensPedidosPorClienteModel(nomeDoProduto, categoria);
        
        if (view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("<Selecione uma categoria>")){
            JOptionPane.showMessageDialog(view, "Selecione uma categoria");
               
                
        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Smartphones")){
                
            try {
                
                Connection conecta = new Conexao().getConnection();
                ItensPedidosPorClienteDao dao = new ItensPedidosPorClienteDao(conecta);
                ArrayList<ItensPedidosPorClienteModel> lista = dao.listandoOsValoresDoBancoComOBotao(model);
                 
                for (ItensPedidosPorClienteModel busca : lista){
                    
                    view.getjTextFieldValor().setText(view.getjTextFieldValor().getText() + busca.getValor());
                    view.getjTextFieldQuantidadeEmEstoque().setText(view.getjTextFieldQuantidadeEmEstoque().getText() + busca.getQuatidadeEmEstoque());
                    
                }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ItensPedidosPorClienteController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, "Erro no metodo listandoValoresDoBancoNoBotaoBuscar: \n" + ex);
                
            }
     
        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Acessorios")){
            
             try {
                
                Connection conecta = new Conexao().getConnection();
                ItensPedidosPorClienteDao dao = new ItensPedidosPorClienteDao(conecta);
                ArrayList<ItensPedidosPorClienteModel> lista = dao.listandoOsValoresDoBancoComOBotao(model);
                 
                for (ItensPedidosPorClienteModel busca : lista){
                    
                    view.getjTextFieldValor().setText(view.getjTextFieldValor().getText() + busca.getValor());
                    view.getjTextFieldQuantidadeEmEstoque().setText(view.getjTextFieldQuantidadeEmEstoque().getText() + busca.getQuatidadeEmEstoque());
                    
                }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ItensPedidosPorClienteController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, "Erro no metodo listandoValoresDoBancoNoBotaoBuscar: \n" + ex);
            }   
            
            
        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Hardwares")){
            try {
                
                Connection conecta = new Conexao().getConnection();
                ItensPedidosPorClienteDao dao = new ItensPedidosPorClienteDao(conecta);
                ArrayList<ItensPedidosPorClienteModel> lista = dao.listandoOsValoresDoBancoComOBotao(model);
                 
                for (ItensPedidosPorClienteModel busca : lista){
                    
                    view.getjTextFieldValor().setText(view.getjTextFieldValor().getText() + busca.getValor());
                    view.getjTextFieldQuantidadeEmEstoque().setText(view.getjTextFieldQuantidadeEmEstoque().getText() + busca.getQuatidadeEmEstoque());
                    
                }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ItensPedidosPorClienteController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, "Erro no metodo listandoValoresDoBancoNoBotaoBuscar: \n" + ex);
            }  
 
        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Consoles")){
           
            try {
                
                Connection conecta = new Conexao().getConnection();
                ItensPedidosPorClienteDao dao = new ItensPedidosPorClienteDao(conecta);
                ArrayList<ItensPedidosPorClienteModel> lista = dao.listandoOsValoresDoBancoComOBotao(model);
                 
                for (ItensPedidosPorClienteModel busca : lista){
                    
                    view.getjTextFieldValor().setText(view.getjTextFieldValor().getText() + busca.getValor());
                    view.getjTextFieldQuantidadeEmEstoque().setText(view.getjTextFieldQuantidadeEmEstoque().getText() + busca.getQuatidadeEmEstoque());
                    
                }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ItensPedidosPorClienteController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, "Erro no metodo listandoValoresDoBancoNoBotaoBuscar: \n" + ex);
            } 
                
        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Jogos")){
            
            try {
                
                Connection conecta = new Conexao().getConnection();
                ItensPedidosPorClienteDao dao = new ItensPedidosPorClienteDao(conecta);
                ArrayList<ItensPedidosPorClienteModel> lista = dao.listandoOsValoresDoBancoComOBotao(model);
                 
                for (ItensPedidosPorClienteModel busca : lista){
                    
                    view.getjTextFieldValor().setText(view.getjTextFieldValor().getText() + busca.getValor());
                    view.getjTextFieldQuantidadeEmEstoque().setText(view.getjTextFieldQuantidadeEmEstoque().getText() + busca.getQuatidadeEmEstoque());
                    
                }
                             
            } catch (SQLException ex) {
                Logger.getLogger(ItensPedidosPorClienteController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, "Erro no metodo listandoValoresDoBancoNoBotaoBuscar: \n" + ex);
            }
   
        }
        
    }
    
    public void utilizandoUpdateDiminuindoAQuantidadeDaEntidadeCategoria(){
        
            String nomeDoProduto = view.getjTextFieldNomeDoProduto().getText();
            String categoria = view.getjComboBoxSeletorDeCategoria().getSelectedItem().toString();
            int quantidade = Integer.parseInt(view.getjTextFieldQuantidade().getText());

        if (view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("<Selecione uma categoria>")){
            JOptionPane.showMessageDialog(view, "Selecione uma categoria");
               

        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Smartphones")){
            
            // Utilizado o (model) para realizar o set das informações do metodo updateDiminuindoAQuantidadeDaEntidadeCategoria
            ItensPedidosPorClienteModel model = new ItensPedidosPorClienteModel(nomeDoProduto, categoria, quantidade);
  
            try {
                
                Connection conecta = new Conexao().getConnection();
                ItensPedidosPorClienteDao dao = new ItensPedidosPorClienteDao(conecta);
                dao.updateDiminuindoAQuantidadeDaEntidadeCategoria(model);
                
                  
            } catch (SQLException ex) {
                Logger.getLogger(ItensPedidosPorClienteController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, "Erro no metodo utilizandoUpdateDiminuindoAQuantidadeDaEntidadeCategoria: \n" + ex);
                       
            }
            
        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Acessorios")){
            
            // Utilizado o (model) para realizar o set das informações do metodo updateDiminuindoAQuantidadeDaEntidadeCategoria
            ItensPedidosPorClienteModel model = new ItensPedidosPorClienteModel(nomeDoProduto, categoria, quantidade);
  
            try {
                
                Connection conecta = new Conexao().getConnection();
                ItensPedidosPorClienteDao dao = new ItensPedidosPorClienteDao(conecta);
                dao.updateDiminuindoAQuantidadeDaEntidadeCategoria(model);
                
                  
            } catch (SQLException ex) {
                Logger.getLogger(ItensPedidosPorClienteController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, "Erro no metodo utilizandoUpdateDiminuindoAQuantidadeDaEntidadeCategoria: \n" + ex);
            }
                  
        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Hardwares")){
            
            // Utilizado o (model) para realizar o set das informações do metodo updateDiminuindoAQuantidadeDaEntidadeCategoria
            ItensPedidosPorClienteModel model = new ItensPedidosPorClienteModel(nomeDoProduto, categoria, quantidade);
  
            try {
                
                Connection conecta = new Conexao().getConnection();
                ItensPedidosPorClienteDao dao = new ItensPedidosPorClienteDao(conecta);
                dao.updateDiminuindoAQuantidadeDaEntidadeCategoria(model);
                
                  
            } catch (SQLException ex) {
                Logger.getLogger(ItensPedidosPorClienteController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, "Erro no metodo utilizandoUpdateDiminuindoAQuantidadeDaEntidadeCategoria: \n" + ex);
            }
              
        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Consoles")){
            
            // Utilizado o (model) para realizar o set das informações do metodo updateDiminuindoAQuantidadeDaEntidadeCategoria
            ItensPedidosPorClienteModel model = new ItensPedidosPorClienteModel(nomeDoProduto, categoria, quantidade);
  
            try {
                
                Connection conecta = new Conexao().getConnection();
                ItensPedidosPorClienteDao dao = new ItensPedidosPorClienteDao(conecta);
                dao.updateDiminuindoAQuantidadeDaEntidadeCategoria(model);
                
                  
            } catch (SQLException ex) {
                Logger.getLogger(ItensPedidosPorClienteController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, "Erro no metodo utilizandoUpdateDiminuindoAQuantidadeDaEntidadeCategoria: \n" + ex);
            }

        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Jogos")){
            
            // Utilizado o (model) para realizar o set das informações do metodo updateDiminuindoAQuantidadeDaEntidadeCategoria
            ItensPedidosPorClienteModel model = new ItensPedidosPorClienteModel(nomeDoProduto, categoria, quantidade);
  
            try {
                
                Connection conecta = new Conexao().getConnection();
                ItensPedidosPorClienteDao dao = new ItensPedidosPorClienteDao(conecta);
                dao.updateDiminuindoAQuantidadeDaEntidadeCategoria(model);
                
                  
            } catch (SQLException ex) {
                Logger.getLogger(ItensPedidosPorClienteController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, "Erro no metodo utilizandoUpdateDiminuindoAQuantidadeDaEntidadeCategoria: \n" + ex);
            }
              
        }
    }
    
    public void utilizandoResultSetParaDentroDaJtable(){
        
        String cpf = view.getjTextFieldCpf().getText();   
        ItensPedidosPorClienteModel model = new ItensPedidosPorClienteModel(cpf);
        DefaultTableModel tabela = (DefaultTableModel) view.getjTableIdDoPedido().getModel();
            
            try {
                
                Connection conecta = new Conexao().getConnection();
                ItensPedidosPorClienteDao dao = new ItensPedidosPorClienteDao(conecta);
                ArrayList<ItensPedidosPorClienteModel> lista = dao.listandoOIdDoPedido(model);
                
                
                for (ItensPedidosPorClienteModel busca : lista){
                    tabela.addRow(new Object[]{
                        busca.getIdDoPedido()
                         });

                     }  
                
                   
            } catch (SQLException ex) {
                Logger.getLogger(ItensPedidosPorClienteController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, "Erro no metodo utilizandoResultSetParaDentroDaJtable: \n" + ex);
                
            }
      
    }
    
}
