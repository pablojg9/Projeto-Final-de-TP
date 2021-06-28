package com.projeto.ui.caixaeletronico;

public class Conta {
    /*
    ATRIBUTOS: S�O ESTRUTURAS QUE REPRESENTAM
    OS DADOS DA CLASSE. EX.: AGENCIA, CONTA, SALDO, SENHA
    ATRIBUTOS POSSUEM DUAS ESTRUTURAS B�SICAS: VISIBILIDADE E TIPO DE DADO
    VISIBILIDADE: DEFINE O N�VEL DE ACESSO NO PROJETO
    TIPO DE DADO: DEFINE A CAPACIDADE DE ARMAZENAMENTO DE DADO DO ATRIBUTO.
    */
    /*
    DECLARA��O DOS ATRIBUTOS DA CLASSE CONTA
    ESTRUTURA DE DECLARA��O DE UM ATRIBUTO:
    1� PARTE - VISIBILIDADE
    2� PARTE - TIPO
    3� PARTE - NOME
    OPICIONAL:
    4� PARTE - ATRIBUI��O DE VALOR OU DE DADO
    */
    /*
    TIPOS DE VISIBILIDADES:
    PUBLIC - PERMITE ACESSO DE QUALQUER ESTRUTURA DO C�DIGO
    PROTECTED
    PRIVATE
    */
    public String agencia = "000-20-X";
    public String nroConta = "1234-0002-B";
    public float saldo = 6000f;


    /*
    M�TODOS: S�O ESTRUTURAS QUE REPRESENTAM AS
    A��ES QUE A CLASSE � CAPAZ DE EXECUTAR.
    VERIFICAR SALDO, REALIZAR DEP�SITO, REALIZAR SAQUE

    DECLARA��O DE M�TODOS:
    1� PARTE - VISIBILIDADE
    2� PARTE - TIPO RETORNO DO M�TODO
    3� PARTE - NOME DO M�TODO
    4� PARTE  - CABE�ALHO DE PARAMETROS
    5� PARTE - CORPO DO M�TODO
    */
    public float verificarSaldo(){

        //S�IDA DE TEXTO DO M�TODO verificarSaldo:        
        return this.saldo;

    }//FECHAMENTO DO M�TODO
    
    /*M�TODO DE REALIZAR DEPOSITO*/
    public void realizarDeposito(float valor){

        /*PRIMEIRA FORMA*/
        //this.saldo = this.saldo + valor;

        /*SEGUNDA FORMA*/
    	
        this.saldo += valor;
        
        if (valor < 0) {
        	this.saldo = 6000f;
        }
        

    }

    /*M�TODO DE REALIZAR SAQUE*/
    public void realizarSaque(float valor){
    	
        this.saldo -= valor;
        
        if (valor < 0) {
        	this.saldo = 6000f;
        }
        
        
    }
    
}
