package Netology.part2.Stream;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> surnames = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    surnames.get(new Random().nextInt(names.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)]));
        }


        persons.stream()
                .filter(person -> person.getAge()<18)
                .count();

        List<Person> rookie = persons.stream()
                .filter(person -> person.getAge()>=18)
                .filter(person -> person.getAge()<=27)
                .filter(person -> person.getSex()==Sex.MAN)
                .collect(Collectors.toList());

        List<Person> performance = persons.stream()
                .filter(person -> person.getEducation()==Education.HIGHER)
                .filter(person -> person.getAge()>=18)
                .filter(person -> (person.getSex()==Sex.WOMAN && person.getAge()<60)
                        || (person.getSex()==Sex.MAN&&person.getAge()<65))
                .sorted(Comparator.comparing(Person::getSurname))
                .collect(Collectors.toList());

    }
}
