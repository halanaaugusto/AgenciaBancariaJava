package br.senai.sp.jandira.model;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

    Cliente refcliente = new Cliente();

    Conta refconta = new Conta();

    public void executarMenu() {

        boolean exit = false;

        while (!exit) {

            System.out.println("=========== Menu ===========");
            System.out.println("1- Cadastrar Cliente        ");
            System.out.println("2- Gerar Conta              ");
            System.out.println("3- Consultar Saldo          ");
            System.out.println("4- Realizar Depósito        ");
            System.out.println("5- Realizar Saque           ");
            System.out.println("6- Realizar Transferência   ");
            System.out.println("7- Sair                     ");
            System.out.println("============================");

            int optionUser = scanner.nextInt();
            scanner.nextLine();

            switch (optionUser) {
                case 1:
                    Cliente cliente = new Cliente();
                    cliente.cadastrarCliente();
                    refcliente.adicionarCliente(cliente);
                    break;

                case 2:
                    System.out.println("Informe o CPF do Titular: ");
                    long cpfTitular = scanner.nextLong();
                    scanner.nextLine();

                    Cliente clienteConta = refcliente.pesquisarCliente(cpfTitular);

                    if (clienteConta != null){
                        Conta conta = new Conta();
                        conta.gerarConta(clienteConta);
                        refconta.adicionarConta(conta);
                        System.out.println("Conta criada com sucesso!");
                    } else {
                        System.out.println("O cliente não tem cadastro.");
                    }
                    break;

                case 3:
                    System.out.println("Informe o CPF do Titular: ");
                    long cpfSaldo = scanner.nextLong();
                    scanner.nextLine();

                    Conta contaSaldo = refconta.pesquisarConta(cpfSaldo);

                    if (contaSaldo != null){
                        contaSaldo.consultarSaldo();
                    } else {
                        System.out.println("O cliente não tem conta cadastrada.");
                    }
                    break;

                case 4:
                    System.out.println("Informe o CPF do Titular: ");
                    long cpfDeposito = scanner.nextLong();
                    scanner.nextLine();

                    Conta contaDeposito = refconta.pesquisarConta(cpfDeposito);

                    if (contaDeposito != null){
                        System.out.println("Informe o valor para depósito: ");
                        double valorDeposito = scanner.nextDouble();
                        scanner.nextLine();

                        contaDeposito.realizarDeposito(valorDeposito);
                    } else {
                        System.out.println("O cliente não tem conta cadastrada.");
                    }
                    break;

                case 5:
                    System.out.println("Informe o CPF do Titular: ");
                    long cpfSaque = scanner.nextLong();
                    scanner.nextLine();

                    Conta contaSaque = refconta.pesquisarConta(cpfSaque);

                    if (contaSaque != null){
                        System.out.println("Informe o valor para sacar: ");
                        double valorSaque = scanner.nextDouble();
                        scanner.nextLine();

                        contaSaque.realizarDeposito(valorSaque);
                    } else {
                        System.out.println("O cliente não tem conta cadastrada.");
                    }
                    break;

                case 6:
                    System.out.println("Informe o CPF do Titular: ");
                    long cpfTransferencia = scanner.nextLong();
                    System.out.println("Informe o CPF do destinatário: ");
                    long cpfContaDestino = scanner.nextLong();
                    scanner.nextLine();

                    Conta contaOrigem = refconta.pesquisarConta(cpfTransferencia);
                    Conta contaDestino = refconta.pesquisarConta(cpfContaDestino);

                    if (contaOrigem != null && contaDestino != null){
                        refconta.realizarTransferencia(contaOrigem, contaDestino);
                    } else {
                        System.out.println("Por favor verifique as informações digitadas.");
                    }
                    break;

                case 7:
                    exit = true;
                    break;
            }

        }

    }
}
