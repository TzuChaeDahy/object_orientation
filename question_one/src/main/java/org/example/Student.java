package org.example;

import java.util.UUID;

public class Student extends Person {
    private UUID number;
    private Double noteOne;
    private Double noteTwo;

    public Student(UUID number,String name, String address, Double noteOne, Double noteTwo) throws Exception {
        super(name, address);

        this.number = number;

        if (noteOne == null || noteOne > 10 || noteOne < 0) {
            throw new Exception("Note one must be between 0 and 10");
        }

        if (noteTwo == null || noteTwo > 10 || noteTwo < 0) {
            throw new Exception("Note two must be between 0 and 10");
        }
        this.noteOne = noteOne;
        this.noteTwo = noteTwo;
    }

    public UUID getNumber() {
        return number;
    }

    public Double getNoteOne() {
        return noteOne;
    }

    public Double getNoteTwo() {
        return noteTwo;
    }

    public Double getAverage() {
        return (noteOne + noteTwo) / 2;
    }
}
