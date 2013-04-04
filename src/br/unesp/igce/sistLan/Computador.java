/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.igce.sistLan;

/**
 *
 * @author Raquel
 */
public class Computador {
    int numero;
    String marca;
    String ip;
    int memRam;
    String hd;
    String processador;
    RegistroUtilizacaoComputador[] utilizacoes;
    RegistroUtilizacaoComputador ultimaUlitizacao;
    String status; //funcionando || em matutenção
    boolean uso; //uso = true, disponivel = false
    double horaTermino;
    
    static int pUtilizacao=0;
    
    public Computador(int numero, String marca, String ip, int memRam, String hd, String processador){
        this.numero = numero;
        this.marca = marca;
        this.ip = ip;
        this.memRam = memRam;
        this.hd = hd;
        this.processador = processador;
        this.status = "funcionando";
        this.uso = false;
        this.horaTermino = 0;
        this.utilizacoes = new RegistroUtilizacaoComputador[1000];
    }
    
    public void novaUtilizacao(RegistroUtilizacaoComputador r){
        
        if (this.uso == true) System.out.println("Computador em uso!");
        else{        
            this.utilizacoes[Computador.pUtilizacao++] = r;
            this.ultimaUlitizacao = r;
            System.out.println(""
                    + "Iniciado o uso do computador numero " 
                    + this.numero + "\n"
                    + "Até o horario :"
                    + r.hora);
        }
    }
    
    public void imprime(){
        System.out.println(""
                + "Numero:" + this.numero + "\n"
                + "Marca:" + this.marca + "\n"
                + "Processador: " + this.processador + "\n"
                + "Memoria RAM: " + this.memRam + " GB" + "\n"
                + "HD: " + this.hd + "\n"
                + "IP: " + this.ip + "\n"
                + "Status: " + this.status  + "\n"
                ); 
    }
}