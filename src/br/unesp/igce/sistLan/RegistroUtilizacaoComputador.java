/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.igce.sistLan;

/**
 *
 * @author Raquel
 */
public class RegistroUtilizacaoComputador {
    String data;
    double hora;
    int numeroDoCliente;
    
    public RegistroUtilizacaoComputador(String data, double hora, int numeroDoCliente){
        this.data = data;
        this.hora = hora;
        this.numeroDoCliente = numeroDoCliente;
    }
}