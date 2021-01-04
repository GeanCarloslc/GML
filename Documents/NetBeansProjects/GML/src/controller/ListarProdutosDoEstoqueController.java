/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.Conexao;
import dao.ListarProdutosDoEstoqueDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ListarProdutosDoEstoqueModel;
import view.ListarProdutosDoEstoqueView;

/**
 *
 * @author topga
 */
public class ListarProdutosDoEstoqueController {
    
    private ListarProdutosDoEstoqueView view;

    public ListarProdutosDoEstoqueController(ListarProdutosDoEstoqueView view) {
        this.view = view;
    }
    
    public void buscarProdutoDoBancoDeDados(){
        
            String nomeDoProduto = view.getjTextFieldNomeDoProduto().getText();
            String categoria = view.getjComboBoxSeletorDeCategoria().getSelectedItem().toString();
            ListarProdutosDoEstoqueModel model = new ListarProdutosDoEstoqueModel(nomeDoProduto, categoria);
        
        
        if (view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("<Selecione uma categoria>")){
            JOptionPane.showMessageDialog(view, "Selecione uma categoria");
               
                
      
 
        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Smartphones")){
            

                try {
                    Connection conecta = new Conexao().getConnection();
                    ListarProdutosDoEstoqueDao dao = new ListarProdutosDoEstoqueDao(conecta);
                    ArrayList<ListarProdutosDoEstoqueModel> lista = dao.listandoValoresDoBanco(model);
                    
                    for (ListarProdutosDoEstoqueModel busca : lista){
                        
                        view.getjTextFieldQuantidade().setText(view.getjTextFieldQuantidade().getText() + busca.getQuantidade());
                        view.getjTextFieldValor().setText(view.getjTextFieldValor().getText() + busca.getValor());
                        
                        
                    }
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ListarProdutosDoEstoqueController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            

        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Acessorios")){
            
                try {
                    Connection conecta = new Conexao().getConnection();
                    ListarProdutosDoEstoqueDao dao = new ListarProdutosDoEstoqueDao(conecta);
                    ArrayList<ListarProdutosDoEstoqueModel> lista = dao.listandoValoresDoBanco(model);
                    
                    for (ListarProdutosDoEstoqueModel busca : lista){
                        
                        view.getjTextFieldQuantidade().setText(view.getjTextFieldQuantidade().getText() + busca.getQuantidade());
                        view.getjTextFieldValor().setText(view.getjTextFieldValor().getText() + busca.getValor());
                        
                        
                    }
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ListarProdutosDoEstoqueController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            
        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Hardwares")){
                
                try {
                    Connection conecta = new Conexao().getConnection();
                    ListarProdutosDoEstoqueDao dao = new ListarProdutosDoEstoqueDao(conecta);
                    ArrayList<ListarProdutosDoEstoqueModel> lista = dao.listandoValoresDoBanco(model);
                    
                    for (ListarProdutosDoEstoqueModel busca : lista){
                        
                        view.getjTextFieldQuantidade().setText(view.getjTextFieldQuantidade().getText() + busca.getQuantidade());
                        view.getjTextFieldValor().setText(view.getjTextFieldValor().getText() + busca.getValor());
                        
                        
                    }
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ListarProdutosDoEstoqueController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            
        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Consoles")){
            
                try {
                    Connection conecta = new Conexao().getConnection();
                    ListarProdutosDoEstoqueDao dao = new ListarProdutosDoEstoqueDao(conecta);
                    ArrayList<ListarProdutosDoEstoqueModel> lista = dao.listandoValoresDoBanco(model);
                    
                    for (ListarProdutosDoEstoqueModel busca : lista){
                        
                        view.getjTextFieldQuantidade().setText(view.getjTextFieldQuantidade().getText() + busca.getQuantidade());
                        view.getjTextFieldValor().setText(view.getjTextFieldValor().getText() + busca.getValor());
                        
                        
                    }
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ListarProdutosDoEstoqueController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
 
        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Jogos")){
            
                try {
                    Connection conecta = new Conexao().getConnection();
                    ListarProdutosDoEstoqueDao dao = new ListarProdutosDoEstoqueDao(conecta);
                    ArrayList<ListarProdutosDoEstoqueModel> lista = dao.listandoValoresDoBanco(model);
                    
                    for (ListarProdutosDoEstoqueModel busca : lista){
                        
                        view.getjTextFieldQuantidade().setText(view.getjTextFieldQuantidade().getText() + busca.getQuantidade());
                        view.getjTextFieldValor().setText(view.getjTextFieldValor().getText() + busca.getValor());
                        
                        
                    }
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ListarProdutosDoEstoqueController.class.getName()).log(Level.SEVERE, null, ex);
                }
        
            
        }  
    }
        
          
    
}
