/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.hibernate.cruddao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author diocesse
 */
public class FactoryConexao {
    
    
    private static final  EntityManagerFactory emf =  Persistence.createEntityManagerFactory("CertificadosDigitaisPU");

    public static EntityManagerFactory getEmf() {
        return emf;
    }
    
    public static void main(String[] args) {
        try {
             FactoryConexao.getEmf();
             System.out.println("Tabelas geradas");
        } catch (Exception e) {
            System.err.println("Falha em criar as tabelas");
        }
        
    }
    
    
}
