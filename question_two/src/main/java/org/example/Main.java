package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    private static List<Client> clients = new ArrayList<Client>();

    public static void main(String[] args) throws Exception {
        Boolean running = true;
        while(running) {
            showMenu();

            running = chooseAnOption();
        }
    }

    public static void showMenu() {
        System.out.println("Selecione uma opção: \n");

        System.out.println("1. Cadastrar um cliente");
        System.out.println("2. Consultar dados de um cliente");
        System.out.println("3. Verificar saldo de um cliente");
        System.out.println("4. Efetuar saque da conta");
        System.out.println("5. Efetuar deposito na conta");
        System.out.println("0. Sair");
    }

    public static Boolean chooseAnOption() throws Exception {
        Integer choice = scanner.nextInt();

        switch (choice) {
            case 0:
                return false;
            case 1:
                signUpClient();
                break;
            case 2:
                viewClientInfo();
                break;
            case 3:
                viewClientAmount();
                break;
            case 4:
                executeWithdraw();
                break;
            case 5:
                executeDeposit();
                break;
            default:
                System.out.println("Opção Inválida!");
        }

        return true;
    }

    public static void signUpClient() throws Exception {
        scanner.nextLine();

        String name = "";
        while (name.isEmpty()) {
            System.out.println("Digite o nome do cliente: ");
            name = scanner.nextLine();
            if(name.isEmpty()) {
                System.out.println("Nome inválido! Tente novamente!");
            }
        }

        Client client = new Client(name, clients);
        clients.add(client);

        System.out.println("Cadastrado com sucesso!");
        System.out.println("Número da conta: " + client.getNumber());
    }

    public static void viewClientInfo() {
        System.out.println("Insira o numero da conta: ");
        Integer number = scanner.nextInt();

        for (Client client : clients) {
            if(client.getNumber().equals(number)) {
                System.out.printf("Nome: %s\nSaldo: %.2f\n", client.getName(), client.getAmount());
                return;
            }
        }

        System.out.println("Cliente não encontrado!");
    }

    public static void viewClientAmount() {
        System.out.println("Insira o numero da conta: ");
        Integer number = scanner.nextInt();

        for (Client client : clients) {
            if(client.getNumber().equals(number)) {
                System.out.printf("Saldo: %.2f\n", client.getAmount());
                return;
            }
        }

        System.out.println("Cliente não encontrado!");
    }

    private static void executeWithdraw() {
        System.out.println("Insira o numero da conta: ");
        Integer number = scanner.nextInt();

        for (Client client : clients) {
            if(client.getNumber().equals(number)) {
                Double amount = client.getAmount() + 1.0;
                while(amount > client.getAmount()) {
                    System.out.println("Insira o valor que deseja sacar: ");
                    amount = scanner.nextDouble();

                    if (amount > client.getAmount()) {
                        System.out.println("Valor Inválido!");
                    }
                }

                Double clientAmount = client.withdraw(amount);
                System.out.println("Saque realizado com sucesso!");
                System.out.println("Saldo: " + clientAmount);
                return;
            }
        }

        System.out.println("Cliente não encontrado!");
    }

    private static void executeDeposit() {
        System.out.println("Insira o numero da conta: ");
        Integer number = scanner.nextInt();

        for (Client client : clients) {
            if(client.getNumber().equals(number)) {
                Double amount = -1.0;
                while(amount < 0) {
                    System.out.println("Insira o valor que deseja depositar: ");
                    amount = scanner.nextDouble();

                    if (amount < 0) {
                        System.out.println("Valor Inválido!");
                    }
                }

                Double clientAmount = client.deposit(amount);
                System.out.println("Deposito realizado com sucesso!");
                System.out.println("Saldo: " + clientAmount);
                return;
            }
        }

        System.out.println("Cliente não encontrado!");
    }
}