/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author topga
 */
public class CadastroDeUsuarioModel {
    
    private String usuario;
    private String senha;
    private String email;
    
    //Construtor

    public CadastroDeUsuarioModel(String usuario, String senha, String email) {
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
    }

    public CadastroDeUsuarioModel(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }
    
    




    //GETTERS AND SETTERS
    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
        public String getEmail() {
        return email;
    }

    
    
}
