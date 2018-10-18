package Sorting;

import java.util.Arrays;
import java.util.Comparator;

public class MultiKeySort {
    public static void main(String[] args) {
        Employee[] a = {new Employee("Anna", "Cho"),
                new Employee("Ella", "Go"),
                new Employee("Nana", "Cho"),
                new Employee("Jana", "Cho"),
                new Employee("Olga", "Min")};
        Arrays.sort(a, Comparator.comparing(o -> ((Employee) o).givenname));
        Arrays.sort(a, Comparator.comparing(o -> ((Employee) o).surname));
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i].surname + " " + a[i].givenname);
        }
    }
}

class Employee {
    String givenname;
    String surname;

    public Employee(String givenname, String surname) {
        this.givenname = givenname;
        this.surname = surname;
    }
}
