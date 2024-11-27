package org.example;

import java.util.List;

public class Client {
    private Integer number;
    private String name;
    private Double amount;

    public Client(String name, List<Client> clients) throws Exception {
        Integer number = (int) Math.floor(Math.random() * 1000);
        while (!isNumberPossible(number, clients)) {
            number = (int) Math.floor(Math.random() * 1000);
        }
        this.number = number;
        if (name == null || name.isEmpty()) {
            throw new Exception("Nome inválido!");
        }
        this.name = name;
        this.amount = 0.0;
    }

    public Integer getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Double getAmount() {
        return amount;
    }

    public Double deposit(double newAmount) {
        amount += newAmount;

        return amount;
    }

    public Double withdraw(double newAmount) {
        amount -= newAmount;

        return amount;
    }

    private Boolean isNumberPossible(Integer number, List<Client> clients) {
        for (Client client : clients) {
            if (client.number.equals(number)) {
                return false;
            }
        }

        return true;
    }
}