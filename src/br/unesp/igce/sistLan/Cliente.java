/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.igce.sistLan;

/**
 *
 * @author Raquel
 */
public class Cliente {
    public String nome;
    private String cpf;
    private int idade;
    private Endereco enderecoCompleto;
    private String nomeResponsável;
    private int numeroUtilizacoes=0;
    private RegistroUtilizacaoCliente[] utilizacao;
    private String observações;
    
    Cliente(String nome, String cpf, int idade, String rua, int numero, String bairro){
        if (idade<18) System.out.println("Usuário menor de idade nao autorizado sem responsaveis");
        else{
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.enderecoCompleto = new Endereco(rua, numero, bairro);
        this.utilizacao = new RegistroUtilizacaoCliente[100];
        }
    }
    
    Cliente(String nome, String cpf, int idade, Endereco endereco, String nomeResponsavel){        
        if (validaCpf(cpf) == true){
            this.cpf = cpf;
            this.nome = nome;
            this.idade = idade;
            this.enderecoCompleto = endereco;
            this.utilizacao = new RegistroUtilizacaoCliente[100];
            this.nomeResponsável = nomeResponsavel;
 }
        else {
           System.out.println("cpf invalido!");
        }
   }
    
    public void addUtilizacao(RegistroUtilizacaoCliente u){
        this.utilizacao[this.numeroUtilizacoes++] = u;
    }
    
    public void addPenalidade(int p){
        this.utilizacao[this.numeroUtilizacoes].novaPenalidade(p);   //a penalidade é adicionada na ultima utilizacao
    }
    
    public void imprimeCliente(){
        System.out.println("Nome: " + this.nome + "\nIdade: " + this.idade + "\nCPF: " + this.cpf + "\nEndereco:");
        this.enderecoCompleto.imprime();
    }
    
    private boolean validaCpf(String cpf){
        if ("00000000000".equals(cpf) || "11111111111".equals(cpf)
	|| "22222222222".equals(cpf) || "33333333333".equals(cpf)
	|| "44444444444".equals(cpf) || "55555555555".equals(cpf)
	|| "66666666666".equals(cpf) || "77777777777".equals(cpf)
	|| "88888888888".equals(cpf) || "99999999999".equals(cpf)){
	System.out.println("Erro: Numero Invalido! \n\n");
	return false;}
		
	cpf = this.retiraEspaços(cpf);
	if ("".equals(cpf)) return false;
	
	if (cpf.length() != 11) {
		return false;
	}
		
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
		
	if (((cpf.charAt(9)-48) != dig10) || ((cpf.charAt(10)-48) != dig11)){
            return false;
	}
		
	return true;
    }
    
    private String retiraEspaços(String cpf){
	
	for (int i=0; i < cpf.length(); i++){
            if ((cpf.charAt(i) == '.') || (cpf.charAt(i) == '-')){
                String st1, st2;
		st1 = cpf.substring(0, i); 
		st2 = cpf.substring(i+1);
		cpf = st1 + st2;
            }
            else if (((cpf.charAt(i)-48) < 0) || ((cpf.charAt(i)-48) > 9)) {
                    System.out.println("Erro: Seu cpf nao contem somente numeros!");
                    return "";
		}
	}
	return cpf;
    }
}