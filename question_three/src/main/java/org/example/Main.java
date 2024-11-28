package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    private static List<Book> books = new ArrayList<Book>();

    public static void main(String[] args) throws Exception {
        Boolean running = true;
        while(running) {
            showMenu();

            running = chooseAnOption();
        }
    }

    public static void showMenu() {
        System.out.println("Selecione uma opção: \n");

        System.out.println("1. Cadastrar um livro");
        System.out.println("2. Buscar livro por titulo");
        System.out.println("3. Lista livros por autor");
        System.out.println("4. Listar todos os livros");
        System.out.println("0. Sair");
    }

    public static Boolean chooseAnOption() throws Exception {
        Integer choice = scanner.nextInt();

        switch (choice) {
            case 0:
                return false;
            case 1:
                signUpBook();
                break;
            case 2:
                viewBookByTitle();
                break;
            case 3:
                viewBooksByAuthor();
                break;
            case 4:
                viewAllBooks();
                break;
            default:
                System.out.println("Opção Inválida!");
        }

        return true;
    }

    public static void signUpBook() throws Exception {
        scanner.nextLine();

        String title = "";
        while (title.isEmpty()) {
            System.out.println("Digite o titulo do livro: ");
            title = scanner.nextLine();
            if(title.isEmpty()) {
                System.out.println("Titulo inválido! Tente novamente!");
            }
        }

        String isbn = "";
        while (isbn.isEmpty()) {
            System.out.println("Digite o ISBN do livro: ");
            isbn = scanner.nextLine();
            if(isbn.isEmpty()) {
                System.out.println("ISBN inválido! Tente novamente!");
            }
        }

        String author = "";
        while (author.isEmpty()) {
            System.out.println("Digite o Autor do livro: ");
            author = scanner.nextLine();
            if(author.isEmpty()) {
                System.out.println("Autor inválido! Tente novamente!");
            }
        }

        String publisher = "";
        while (publisher.isEmpty()) {
            System.out.println("Digite a Editora do livro: ");
            publisher = scanner.nextLine();
            if(publisher.isEmpty()) {
                System.out.println("Editora inválida! Tente novamente!");
            }
        }

        Integer publishDate = LocalDate.now().getYear() + 1;
        while (publishDate > LocalDate.now().getYear()) {
            System.out.println("Digite o ano de publicação do livro: ");
            publishDate = scanner.nextInt();
            if(publishDate > LocalDate.now().getYear()) {
                System.out.println("Ano de publicação inválido! Tente novamente!");
            }
        }

        Book book = new Book(isbn, title, author, publisher, publishDate);
        books.add(book);

        System.out.println("Cadastrado com sucesso!");
        System.out.println("ISBN: " + book.getIsbn());
    }

    public static void viewBookByTitle() {
        scanner.nextLine();

        System.out.println("Insira o titulo do livro: ");
        String title = scanner.nextLine();

        Boolean bookFound = false;
        for (Book book : books) {
            if(book.getTitle().equals(title)) {
                System.out.printf(
                        "ISBN: %s\nTitulo: %s\nAutor: %s\nEditora: %s\nAno de Publicação: %d\n\n",
                        book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getPublishYear()
                );
                bookFound = true;
            }
        }

        if (!bookFound) {
            System.out.println("Livro não encontrado!");
        }
    }

    public static void viewBooksByAuthor() {
        scanner.nextLine();

        System.out.println("Insira o nome do autor: ");
        String author = scanner.nextLine();

        Boolean bookFound = false;
        for (Book book : books) {
            if(book.getAuthor().equals(author)) {
                System.out.printf(
                        "ISBN: %s\nTitulo: %s\nAutor: %s\nEditora: %s\nAno de Publicação: %d\n\n",
                        book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getPublishYear()
                );
                bookFound = true;
            }
        }

        if (!bookFound) {
            System.out.println("Autor não possui livros cadastrados!");
        }
    }

    public static void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Não há livros cadastrados");
            return;
        }

        for (Book book : books) {
            System.out.printf(
                "ISBN: %s\nTitulo: %s\nAutor: %s\nEditora: %s\nAno de Publicação: %d\n\n",
                book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getPublishYear()
            );
        }
    }
}