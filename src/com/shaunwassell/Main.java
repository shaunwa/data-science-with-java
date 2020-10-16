package com.shaunwassell;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    static void loadAutoMpgExample() {
        List<String> lines = TextLoader.getLines("auto-mpg.data");
        List<CarRecord> cars = lines.stream()
                .map(line -> CarRecord.parseCarRecord(line))
                .collect(Collectors.toList());
        cars.stream().forEach(car -> System.out.println(car));
    }

    static void knnExample() {
        List<String> lines = TextLoader.getLines("auto-mpg.data");
        List<CarRecord> cars = lines.stream()
                .map(line -> CarRecord.parseCarRecord(line))
                .collect(Collectors.toList());
        Collections.shuffle(cars);

        List<CarRecord> testCars = cars.subList(0, 10);
        List<CarRecord> restOfCars = cars.subList(10, cars.size());

        KNNClassifier classifier = new KNNClassifier();

        restOfCars.stream().forEach(car -> classifier.addDataPoint(
                new DataPoint(car.displacement, car.weight, car.mpg > 25 ? "High" : "Low")
        ));

        List<Map<String, Integer>> results = testCars.stream()
            .map(testCar -> classifier.classifyPoint(testCar.displacement, testCar.weight, 5))
            .collect(Collectors.toList());

        System.out.println(results);
    }

    public static void main(String[] args) {
        knnExample();
        // univariate array representation (columns)
        Integer[] ids = { 123, 234, 345, 456, 567 };
        String[] names = { "John Doe", "Jane Plain", "Joan Jones", "Jack Sparrow", "Sonic the Hedgehog" };
        Boolean[] likesPizza = { false, true, true, false, true };

        // multivariate array rep. (rows)
        Integer[] person1 = { 123, 1994, 0 };
        Integer[] person2 = { 234, 1980, 1 };
        Integer[] person3 = { 345, 1975, 0 };

        // Matrix rep.
        Integer[][] people = {
            { 123, 1994, 0 },
            { 234, 1980, 1 },
            { 345, 1975, 0 }
        };

        Person[] peopleArr = {
                new Person(123, "John Doe", 23, false),
                new Person(123, "John Doe", 23, false),
                new Person(123, "John Doe", 23, false),
        };

        // load data from file
        // for each line:
//        Person myPerson = Person.parsePerson(line);
    }

    static class PersonUtil {
        // ... .
    }

    // Data objects
    static class Person {
        public final Integer id;
        public final String name;
        public final Integer age;
        public final Boolean likesPizza;

        static Boolean isOlder(Person person1, Person person2) {
            return person1.age > person2.age;
        }

        public Person(Integer id, String name, Integer age, Boolean likesPizza) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.likesPizza = likesPizza;
        }
    }
}
