package br.senai.sp.jandira.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conta {
    private String agencia = "1258-X";
    private int numeroConta;
    private double saldo = 0;

    private Cliente cliente;

    List<Conta> listConta = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Conta pesquisarConta(long cpf) {
        for (Conta conta : listConta) {
            long cpfConta = conta.cliente.getCpf();

            if (cpfConta == cpf) {
                return conta;
            }
        }
        return null;
    }

    public void adicionarConta(Conta conta) {
        listConta.add(conta);
    }

    public void gerarConta(Cliente cliente) {
        this.cliente = cliente;
        numeroConta = (int) (Math.random() * 10000);
    }

    public void realizarTransferencia(Conta contaUser, Conta contaDestino) {
        System.out.println("Informe o valor para transferência: ");
        double valorTransferencia = scanner.nextDouble();
        scanner.nextLine();

        double saldoDisponivel = contaUser.getSaldo();

        if (saldoDisponivel >= valorTransferencia) {
            saldoDisponivel -= valorTransferencia;
            contaUser.setSaldo(saldoDisponivel);

            double saldoDestinatario = contaDestino.getSaldo();
            saldoDestinatario += valorTransferencia;
            contaDestino.setSaldo(saldoDestinatario);
            System.out.println("Transferência de R$: " + valorTransferencia + "realizada com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para realizar a transferência");
        }

    }

    public void realizarDeposito(double valor) {
        this.saldo += valor;
        System.out.println("Saldo disponível: " + this.saldo);
    }

    public void realizarSaque(double valor) {
        boolean validaSaque = avaliarSaque(valor);

        if (validaSaque) {
            this.saldo -= valor;
        } else {
            System.out.println("Impossível realizar o saque");
        }
        System.out.println("Saldo disponível: " + this.saldo);
    }

    public void consultarSaldo() {
        System.out.println("Saldo disponível: " + this.saldo);
    }

    public boolean avaliarSaque(double valor) {
        if (this.saldo >= valor) {
            return true;
        } else {
            return false;
        }
    }


}
