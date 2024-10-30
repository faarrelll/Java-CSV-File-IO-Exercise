package com.enigma.csv_challenge;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVPerson {
    private static final String FILE_NAME = "src/person.csv";

    public static void writePerson(Person person) {
        try (FileWriter fileWriter = new FileWriter(FILE_NAME, true)) {
            injectHeaderColumns(fileWriter);
            fileWriter.write(person.toString());
            fileWriter.write("\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // bukan best practice tapi untuk demo aja
    public static void injectHeaderColumns(FileWriter fileWriter) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {
            if (!bufferedReader.ready()) {
                fileWriter.write("id,name,age");
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Person> getPersonList() {
        List<Person> personList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {
            while (bufferedReader.ready()) {
                String rowValue = bufferedReader.readLine();
                if (rowValue.startsWith("id")) {
                    continue;
                }
                String[] rowValues = rowValue.split(",");
                personList.add(new Person(Integer.parseInt(rowValues[0]), rowValues[1], Integer.parseInt(rowValues[2])));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return personList;
    }

    public void deletePersonById(int id) {

    }
}
