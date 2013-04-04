/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.igce.sistLan;

/**
 *
 * @author Raquel
 */
public class Endereco {
    private String rua;
    private int numero;
    private String bairro;
    private String complemento;
    
    Endereco(String rua, int numero, String bairro){
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
    }

    public void imprime(){
        System.out.println(
                "   rua: " + this.rua +
                "\n   numero: " + this.numero +
                "\n   bairro: " + this.bairro + "\n");
    }
}