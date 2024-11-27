package org.example;

public class Person {
    private String name;
    private String address;

    public Person(String name, String address) throws Exception {
        if (name == null || name.isEmpty()) {
            throw new Exception("Nome de pessoa invalido!");
        }
        this.name = name;

        if (address == null || address.isEmpty()) {
            throw new Exception("Nome de pessoa invalido!");
        }
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
