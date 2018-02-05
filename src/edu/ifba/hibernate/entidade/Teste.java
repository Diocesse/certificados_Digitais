/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.hibernate.entidade;

/**
 *
 * @author diocesse
 */
public class Teste {
    private String cpf;

    public Teste() {
    }

    public Teste(String cpf) {
        this.cpf = cpf;
    }
 
    public String getNome() {
        return cpf;
    }

    public void setNome(String cpf) {
        this.cpf = cpf;
    }
    
}
