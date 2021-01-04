/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CadastroDeUsuarioDao;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.CadastroDeUsuarioModel;
import view.CadastrarClienteView;
import view.CadastroDeUsuarioView;
import view.LoginView;
import view.MenuPrincipalView;

/**
 *
 * @author topga
 */
public class LoginController {
    
    private LoginView view;

    public LoginController(LoginView view) {
        this.view = view;
    }
    
    public void autenticar() {
        
        //Buscando usuário e senha da View
        
        String usuario = view.getjTextFieldUsuario().getText();
        String senha = view.getjTextFieldSenha().getText();
        
        CadastroDeUsuarioModel model = new CadastroDeUsuarioModel(usuario, senha);
        
        //Verificando se existe no banco de dados

        try {
            Connection conexao = new Conexao().getConnection();
            CadastroDeUsuarioDao dao = new CadastroDeUsuarioDao(conexao);
            boolean existe = dao.autenticarUsuarioPorUsuarioESenha(model);
            
            //Se existe direcionando para o MenuPrincipal
            
            if (existe) {
            MenuPrincipalView menu = new MenuPrincipalView();
            menu.setVisible(true);
            }else{
            JOptionPane.showMessageDialog(view, "Usuário ou senha invalidos");
        }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(view, "Todos os dados acima são obrigatorios");
        }
        
    }
    
    public void entrarEmCadastro() {
        CadastroDeUsuarioView cadastroDeUsuarioView = new CadastroDeUsuarioView();
        cadastroDeUsuarioView.setVisible(true);
            
    }
    
    
}
