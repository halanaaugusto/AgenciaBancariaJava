package br.senai.sp.jandira.model;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

    Cliente cliente = new Cliente();

    Conta conta = new Conta();

    public void executarMenu() {

        boolean exit = false;

        while (!exit) {

            System.out.println("=========== Menu ===========");
            System.out.println("1- Cadastrar Cliente        ");
            System.out.println("2- Cadastrar Conta          ");
            System.out.println("3- Consultar Saldo          ");
            System.out.println("4- Realizar Depósito        ");
            System.out.println("5- Realizar Saque           ");
            System.out.println("6- Sair                     ");
            System.out.println("============================");

            int optionUser = scanner.nextInt();
            scanner.nextLine();

            switch (optionUser) {
                case 1:
                    cliente.cadastrarCliente();
                    break;

                case 2:
                    System.out.println("Feature in Development");
                    break;

                case 3:
                    conta.consultarSaldo();
                    break;

                case 4:
                    System.out.println("Informe o valor que deseja depositar: ");
                    double valorDeposito = scanner.nextDouble();
                    scanner.nextLine();
                    conta.realizarDeposito(valorDeposito);
                    break;

                case 5:
                    System.out.println("Informe o valor que deseja sacar: ");
                    double valorSaque = scanner.nextDouble();
                    scanner.nextLine();
                    conta.realizarSaque(valorSaque);
                    break;

                case 6:
                    exit = true;
                    break;
            }

        }

    }
}
