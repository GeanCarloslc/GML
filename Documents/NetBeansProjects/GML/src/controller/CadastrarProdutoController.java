/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CadastrarProdutoDao;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.CadastrarProdutoModel;
import view.CadastrarProdutoView;

/**
 *
 * @author topga
 */
public class CadastrarProdutoController {
    
    private CadastrarProdutoView view;

    public CadastrarProdutoController(CadastrarProdutoView view) {
        this.view = view;
    }
    
    
    public void cadastrarProdutoDesejado(){
        
        if (view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("<Selecione uma categoria>")){
            JOptionPane.showMessageDialog(view, "Selecione uma categoria");
            
           
            
            
        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Smartphones")){
            
            String categoria = view.getjComboBoxSeletorDeCategoria().getSelectedItem().toString();
            String nomeDoProduto = view.getjTextFieldNomeDoProduto().getText();
            float valor = Float.parseFloat(view.getjTextFieldValor().getText());
            int quantidade = Integer.parseInt(view.getjTextFieldQuantidade().getText());
            int id = 1;
            
            
            CadastrarProdutoModel model = new CadastrarProdutoModel(categoria, nomeDoProduto, valor, quantidade, id);
            
            try {
                
                Connection conecta = new Conexao().getConnection();
                CadastrarProdutoDao dao = new CadastrarProdutoDao(conecta);
                
                dao.cadastrarProdutoNoBanco(model);
                JOptionPane.showMessageDialog(view, "Produto cadastrado com sucesso!");
                
                
            } catch (SQLException ex) {
                Logger.getLogger(CadastrarProdutoController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, "Erro ao cadastrar o produto " + ex);
            }

        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Acessorios")){
            
            String categoria = view.getjComboBoxSeletorDeCategoria().getSelectedItem().toString();
            String nomeDoProduto = view.getjTextFieldNomeDoProduto().getText();
            float valor = Float.parseFloat(view.getjTextFieldValor().getText());
            int quantidade = Integer.parseInt(view.getjTextFieldQuantidade().getText());
            int id = 2;
            
            
            CadastrarProdutoModel model = new CadastrarProdutoModel(categoria, nomeDoProduto, valor, quantidade, id);
            
            try {
                
                Connection conecta = new Conexao().getConnection();
                CadastrarProdutoDao dao = new CadastrarProdutoDao(conecta);
                
                dao.cadastrarProdutoNoBanco(model);
                JOptionPane.showMessageDialog(view, "Produto cadastrado com sucesso!");
                
                
            } catch (SQLException ex) {
                Logger.getLogger(CadastrarProdutoController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, "Erro ao cadastrar o produto " + ex);
            }
            
            
        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Hardwares")){
            
            String categoria = view.getjComboBoxSeletorDeCategoria().getSelectedItem().toString();
            String nomeDoProduto = view.getjTextFieldNomeDoProduto().getText();
            float valor = Float.parseFloat(view.getjTextFieldValor().getText());
            int quantidade = Integer.parseInt(view.getjTextFieldQuantidade().getText());
            int id = 3;
            
            
            CadastrarProdutoModel model = new CadastrarProdutoModel(categoria, nomeDoProduto, valor, quantidade, id);
            
            try {
                
                Connection conecta = new Conexao().getConnection();
                CadastrarProdutoDao dao = new CadastrarProdutoDao(conecta);
                
                dao.cadastrarProdutoNoBanco(model);
                JOptionPane.showMessageDialog(view, "Produto cadastrado com sucesso!");
                
                
            } catch (SQLException ex) {
                Logger.getLogger(CadastrarProdutoController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, "Erro ao cadastrar o produto " + ex);
            }
            
        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Consoles")){
            
            String categoria = view.getjComboBoxSeletorDeCategoria().getSelectedItem().toString();
            String nomeDoProduto = view.getjTextFieldNomeDoProduto().getText();
            float valor = Float.parseFloat(view.getjTextFieldValor().getText());
            int quantidade = Integer.parseInt(view.getjTextFieldQuantidade().getText());
            int id = 4;
            
            
            CadastrarProdutoModel model = new CadastrarProdutoModel(categoria, nomeDoProduto, valor, quantidade, id);
            
            try {
                
                Connection conecta = new Conexao().getConnection();
                CadastrarProdutoDao dao = new CadastrarProdutoDao(conecta);
                
                dao.cadastrarProdutoNoBanco(model);
                JOptionPane.showMessageDialog(view, "Produto cadastrado com sucesso!");
                
                
            } catch (SQLException ex) {
                Logger.getLogger(CadastrarProdutoController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, "Erro ao cadastrar o produto " + ex);
            }
            
            
        }else if(view.getjComboBoxSeletorDeCategoria().getSelectedItem().equals("Jogos")){
            
            String categoria = view.getjComboBoxSeletorDeCategoria().getSelectedItem().toString();
            String nomeDoProduto = view.getjTextFieldNomeDoProduto().getText();
            float valor = Float.parseFloat(view.getjTextFieldValor().getText());
            int quantidade = Integer.parseInt(view.getjTextFieldQuantidade().getText());
            int id = 5;
            
            
            CadastrarProdutoModel model = new CadastrarProdutoModel(categoria, nomeDoProduto, valor, quantidade, id);
            
            try {
                
                Connection conecta = new Conexao().getConnection();
                CadastrarProdutoDao dao = new CadastrarProdutoDao(conecta);
                
                dao.cadastrarProdutoNoBanco(model);
                JOptionPane.showMessageDialog(view, "Produto cadastrado com sucesso!");
                
                
            } catch (SQLException ex) {
                Logger.getLogger(CadastrarProdutoController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, "Erro ao cadastrar o produto " + ex);
            }
            
        }  
    }
    
}
