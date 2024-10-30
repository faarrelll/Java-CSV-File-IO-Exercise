package com.enigma.csv_challenge;


public class Main {
    public static void main(String[] args) {
        Person udin = new Person(1, "Udin", 15);
        CSVPerson.writePerson(udin);

        Person odin = new Person(2, "Odin", 15);
        CSVPerson.writePerson(odin);

        Person Oden = new Person(3, "Oden", 15);
        CSVPerson.writePerson(Oden);

        Person Dino = new Person(4, "Dino", 15);
        CSVPerson.writePerson(Dino);

        Person Doni = new Person(5, "Doni", 15);
        CSVPerson.writePerson(Doni);

        System.out.println(CSVPerson.getPersonList());
    }
}
