/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CadastroDeUsuarioModel;

/**
 *
 * @author topga
 */
public class CadastroDeUsuarioDao {
    
    private Connection conecta;

    public CadastroDeUsuarioDao(Connection conecta) {
        this.conecta = conecta;
    }
    
    public void salvarUsuarioeSenha(CadastroDeUsuarioModel model) throws SQLException{
        
            
        String sql = "INSERT INTO ACESSO(USUARIO, SENHA, EMAIL) VALUES (?,?,?)";
        
        PreparedStatement stmt = conecta.prepareStatement(sql); 
        stmt.setString(1, model.getUsuario());
        stmt.setString(2, model.getSenha());
        stmt.setString(3, model.getEmail());
        stmt.execute();
        conecta.close();
        
        
        
        
    }

    public boolean autenticarUsuarioPorUsuarioESenha(CadastroDeUsuarioModel model) throws SQLException {
          
        String sql = "SELECT * FROM ACESSO WHERE USUARIO = ? AND SENHA = ?";
        
        PreparedStatement stmt = conecta.prepareStatement(sql);
        
        stmt.setString(1, model.getUsuario());
        stmt.setString(2, model.getSenha());
        

        stmt.execute();
        conecta.close();
        
        ResultSet resultSet = stmt.getResultSet();
        
       
        return resultSet.next();
        
    }


    
}
