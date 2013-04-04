/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.igce.sistLan;

/**
 *
 * @author Raquel
 */
public class Main {
    public static void main(String[] args) {
        
        PovoadorCliente p = new PovoadorCliente();
        
        Cliente[] clientes = new Cliente[100];
        
        for(int i=0; i<5; i++){
            int idade = p.gerarIdade();
            String responsavel;
            if (idade<18) {
                responsavel = p.gerarNome();
            } else {
                responsavel = "";
            }
            clientes[i] = new Cliente(p.gerarNome(),p.gerarCpf(),idade,p.gerarEndereco(),responsavel);
            clientes[i].imprimeCliente();
        }
        
        PovoadorComputador p2 = new PovoadorComputador();
        Computador[] computadores = new Computador[100];
        for (int i=0; i<3; i++){
            computadores[i] = new Computador(p2.gerarNumero(), p2.gerarMarca(), p2.gerarIp(), p2.gerarRam(), p2.gerarHd(), p2.gerarProcessador());
            computadores[i].imprime();
        }
        
    }
}
