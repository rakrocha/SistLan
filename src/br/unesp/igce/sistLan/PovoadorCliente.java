/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.igce.sistLan;

/**
 *
 * @author Raquel
 */

import java.util.Random;

public class PovoadorCliente {
    private Random g;
    
    public PovoadorCliente () {
        g = new Random();
    }
    
    private String[] prenomesMasc = {
        "José",
        "João",
        "Daniel",
        "Márcio",
        "Roberto"};
    
    private String[] prenomesFem = {
        "Raquel",
        "Vanessa",
        "Renata"
    };
    
    private String[] sobrenomes = {
        "Albuquerque",
        "Alcantara",
        "Viotti",
        "Tanamura"
    };
    
    private String[] ruas = {
        "Sebastiao de P. Coelho",
        "Panamá",
        "São Judas Tadeu",
        "Hortências",
        "Pedro Chinellato",
        "José Levy"
    };
    
    private String[] bairros = {
        "Centro",
        "Prq Hipólito",
        "Novo Mundo",
        "Jd Brasil"
    };
    
    private String gerarSobrenome() {
        int sorteio = g.nextInt(100);
        if (sorteio < 15) {
            return sobrenomes[g.nextInt(sobrenomes.length)];
        } else if (sorteio < 35){
            return "de " +
                   sobrenomes[g.nextInt(sobrenomes.length)] +
                   " " +
                   sobrenomes[g.nextInt(sobrenomes.length)];
        } else if (sorteio < 45) {
            return sobrenomes[g.nextInt(sobrenomes.length)] +
                   " de " +
                   sobrenomes[g.nextInt(sobrenomes.length)];
        } else {
            return sobrenomes[g.nextInt(sobrenomes.length)] +
                   " " +
                   sobrenomes[g.nextInt(sobrenomes.length)];
        }
    }
    
    public String gerarNome(){
        int sorteio = g.nextInt(100);
        int genero = g.nextInt(2);
        
        String sobrenome = gerarSobrenome();
        
        if (genero == 0){
            if (sorteio<30) {
                return prenomesMasc[g.nextInt(prenomesMasc.length)]
                     + " "
                     + prenomesMasc[g.nextInt(prenomesMasc.length)]
                     + " "
                     + sobrenome;
            } else {
                return prenomesMasc[g.nextInt(prenomesMasc.length)]
                     + " "
                     + sobrenome;
            }
        } else {
            if (sorteio<30) {
                return prenomesFem[g.nextInt(prenomesFem.length)]
                     + " "
                     + prenomesFem[g.nextInt(prenomesFem.length)]
                     + " "
                     + sobrenome;
            } else {
                return prenomesFem[g.nextInt(prenomesFem.length)]
                     + " "
                     + sobrenome;
            }
        }
    }
    
    public int gerarIdade(){
        return g.nextInt(100);
    }
    
    private String gerarRua(){
        return ruas[g.nextInt(ruas.length)];
    }
    
    private int gerarNum(){
        return g.nextInt(5000);
    }
    
    private String gerarBairro(){
        return bairros[g.nextInt(bairros.length)];
    }
    
    public Endereco gerarEndereco(){     
        return new Endereco(gerarRua(), gerarNum(), gerarBairro());
    }
    
    private String addDigitos(String cpf){
        
        double soma=0;
	int peso=10;
        
	for(int i=0; i<9; i++){
		int num = cpf.charAt(i) - 48;
		soma = soma + peso*num;
		peso--;
	}
		
	int dig10 = (int)soma % 11;
	if (dig10<=2) dig10=0;
	else dig10 = 11 - dig10;
	
	soma=0;
	peso=11;
	
	for(int i=0; i<9; i++){
		int num = cpf.charAt(i) - 48;
                soma = soma + peso*num;
		peso--;
	}
	soma = soma + peso*dig10;
		
	int dig11 = (int)(soma % 11);
	if (dig11<=2) dig11=0;
	else dig11 = 11 - dig11;
            
        cpf = cpf + dig10 + dig11;
        
        return cpf;
    }
   
    public String gerarCpf(){     
        String cpf = "";
        
        for (int i=0; i<9; i++){
            cpf = cpf + g.nextInt(10);
        }
        
        cpf = addDigitos(cpf);
        return cpf;
    }
}