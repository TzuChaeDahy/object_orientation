package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static List<Student> students = new ArrayList<Student>();

    public static void main(String[] args) throws Exception {
        Boolean running = true;
        while(running) {
            showMenu();

            running = chooseAnOption();
        }
    }

    public static void showMenu() {
        System.out.println("Selecione uma opção: \n");

        System.out.println("1. Cadastrar um estudante");
        System.out.println("2. Calcular a média de um estudante");
        System.out.println("3. Consultar a matricula dos estudantes");
        System.out.println("4. Consultar endereço de um estudante");
        System.out.println("5. Consultar a média da turma");
        System.out.println("6. Exibir os nomes do estudantes reprovados");
        System.out.println("0. Sair");
    }

    public static Boolean chooseAnOption() throws Exception {
        Integer choice = scanner.nextInt();

        switch (choice) {
            case 1:
                signUpStudent();
                break;
            case 2:
                viewStudentAverageNote();
                break;
            case 3:
                viewAllStudentsNumber();
                break;
            case 4:
                viewStudentAddress();
                break;
            case 5:
                viewClassAverageNote();
                break;
            case 6:
                viewReprovedStudents();
                break;
            default:
                System.out.println("Opção Inválida!");
                return false;
        }

        return true;
    }

    public static void signUpStudent() throws Exception {
        scanner.nextLine();

        String name = "";
        while (name.isEmpty()) {
            System.out.println("Digite o nome do estudante: ");
            name = scanner.nextLine();
            if(name.isEmpty()) {
                System.out.println("Nome inválido! Tente novamente!");
            }
        }

        String address = "";
        while (address.isEmpty()) {
            System.out.println("Digite o endereço do estudante: ");
            address = scanner.nextLine();
            if(address.isEmpty()) {
                System.out.println("Endereço inválido! Tente novamente!");
            }
        }

        Double firstNote = -1.0;
        while(firstNote > 10 || firstNote < 0) {
            System.out.println("Digite a primeira nota do estudante: ");
            firstNote = scanner.nextDouble();
            if (firstNote > 10 || firstNote < 0) {
                System.out.println("Nota inválida! Insira novamente!");
            }
        }

        Double secondNote = -1.0;
        while(secondNote > 10 || secondNote < 0) {
            System.out.println("Digite a segunda nota do estudante: ");
            secondNote = scanner.nextDouble();
            if (secondNote > 10 || secondNote < 0) {
                System.out.println("Nota inválida! Insira novamente!");
            }
        }

        UUID id = UUID.randomUUID();
        Student student = new Student(id, name, address, firstNote, secondNote);
        students.add(student);

        System.out.println("Cadastrado com sucesso!");
        System.out.println("ID: " + id);
    }

    public static void viewStudentAverageNote() {
        System.out.println("Insira o id do estudante: ");
        UUID id = null;
        try {
            id = UUID.fromString(scanner.next());
        } catch (IllegalArgumentException exception) {
            System.out.println("ID Invalido!");
            return;
        }

        for (Student student : students) {
            if(student.getNumber().equals(id)) {
                System.out.printf("Nota Média do Estudante %s: %.2f\n", student.getName(), student.getAverage());
                return;
            }
        }

        System.out.println("Estudante não encontrado!");
    }

    private static void viewAllStudentsNumber() {
        if (students.isEmpty()) {
            System.out.println("Não há estudantes cadastrados!");
            return;
        }

        for(Student student : students) {
            System.out.printf("ID: %s\nNome: %s\n\n", student.getNumber(), student.getName());
        }
    }

    private static void viewStudentAddress() {
        System.out.println("Insira o id do estudante: ");
        UUID id = null;
        try {
            id = UUID.fromString(scanner.next());
        } catch (IllegalArgumentException exception) {
            System.out.println("ID Invalido!");
            return;
        }

        for (Student student : students) {
            if(student.getNumber().equals(id)) {
                System.out.printf("Endereço do Estudante %s: %s\n", student.getName(), student.getAddress());
                return;
            }
        }

        System.out.println("Estudante não encontrado!");
    }

    private static void viewClassAverageNote() {
        if (students.isEmpty()) {
            System.out.println("Não há estudantes cadastrados!");
            return;
        }

        Double sum = 0.0;
        for (Student student : students) {
            sum += student.getAverage() * 2;
        }

        Double average = sum / (students.size() * 2);

        System.out.println("A média da turma é: " + average);
    }

    private static void viewReprovedStudents() {
        if (students.isEmpty()) {
            System.out.println("Não há estudantes cadastrados!");
            return;
        }

        for(Student student : students) {
            if(student.getAverage() < 7) {
                System.out.printf("Nome: %s\nMédia: %.2f\n\n", student.getName(), student.getAverage());
            }
        }
    }
}