package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    private static List<Product> products = new ArrayList<Product>();

    public static void main(String[] args) throws Exception {
        Boolean running = true;
        while(running) {
            showMenu();

            running = chooseAnOption();
        }
    }

    public static void showMenu() {
        System.out.println("Selecione uma opção: \n");

        System.out.println("1. Cadastrar um produto");
        System.out.println("2. Buscar produto por nome");
        System.out.println("3. Listar todos os produtos");
        System.out.println("4. Efetuar uma venda");
        System.out.println("0. Sair");
    }

    public static Boolean chooseAnOption() throws Exception {
        Integer choice = scanner.nextInt();

        switch (choice) {
            case 0:
                return false;
            case 1:
                signUpProduct();
                break;
            case 2:
                viewProductByName();
                break;
            case 3:
                viewAllProducts();
                break;
            case 4:
                executeASell();
                break;
            default:
                System.out.println("Opção Inválida!");
        }

        return true;
    }

    public static void signUpProduct() throws Exception {
        scanner.nextLine();

        String name = "";
        while (name.isEmpty()) {
            System.out.println("Digite o nome do produto: ");
            name = scanner.nextLine();
            if(name.isEmpty()) {
                System.out.println("Nome inválido! Tente novamente!");
            }
        }

        Double price = 0.0;
        while (price <= 0) {
            System.out.println("Digite o Preço do produto: ");
            price = scanner.nextDouble();
            if(price <= 0) {
                System.out.println("Preço inválido! Tente novamente!");
            }
        }

        Integer quantity = -1;
        while (quantity < 0) {
            System.out.println("Digite o Quantidade do produto: ");
            quantity = scanner.nextInt();
            if(quantity < 0) {
                System.out.println("Quantidade inválida! Tente novamente!");
            }
        }

        Product product = new Product(name, price, quantity, products);
        products.add(product);

        System.out.println("Cadastrado com sucesso!");
        System.out.println("Codigo: " + product.getCode());
    }

    public static void viewProductByName() {
        scanner.nextLine();

        System.out.println("Insira o nome do produto: ");
        String name = scanner.nextLine();

        Boolean productFound = false;
        for (Product product : products) {
            if(product.getName().equals(name)) {
                System.out.printf(
                        "Codigo: %d\nNome: %s\nPreço: %.2f\nQuantidade: %d\n\n",
                        product.getCode(), product.getName(), product.getPrice(), product.getQuantity()
                );
                productFound = true;
            }
        }

        if (!productFound) {
            System.out.println("Produto não encontrado!");
        }
    }

    public static void viewAllProducts() {
        scanner.nextLine();

        if (products.isEmpty()) {
            System.out.println("Produtos não encontrados!");
            return;
        }

        for (Product product : products) {
            System.out.printf(
                    "Codigo: %d\nNome: %s\nPreço: %.2f\nQuantidade: %d\n\n",
                    product.getCode(), product.getName(), product.getPrice(), product.getQuantity()
            );
        }
    }

    public static void executeASell() {
        scanner.nextLine();

        System.out.println("Insira o codigo do produto: ");
        Integer code = scanner.nextInt();

        System.out.println("Insira a quantidade do produto a vender: ");
        Integer quantity = scanner.nextInt();

        for (Product product : products) {
            if (product.getCode().equals(code)) {
                if(product.getQuantity() < quantity || quantity <= 0) {
                    System.out.println("Quantidade invalida! Tente novamente!");
                    return;
                }

                product.sellProduct(quantity);

                System.out.println("Venda realizada com sucesso!");
                System.out.printf("Quantidade de Produtos vendidos: %d\n", quantity);
                System.out.printf("Valor total: %.2f\n", quantity * product.getPrice());
                return;
            }
        }

        System.out.println("Produto não encontrado!");
    }
}