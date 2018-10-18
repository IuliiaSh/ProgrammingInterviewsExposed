package Sorting;

import java.util.ArrayList;
import java.util.HashMap;

public class MakeSortStable {
    public static void makeSortStable(Employee[] initialArray, Employee[] surnameSortedArray) {
        HashMap<String, ArrayList<Employee>> keyOrderMap = new HashMap();
        for (int i = 0; i < initialArray.length; i++) {
            keyOrderMap.putIfAbsent(initialArray[i].surname, new ArrayList());
            keyOrderMap.get(initialArray[i].surname).add(initialArray[i]);
        }

        int i = 0;
        String nextSurname;
        ArrayList<Employee> nextOrder;
        while (i < surnameSortedArray.length) {
            nextSurname = surnameSortedArray[i].surname;
            nextOrder = keyOrderMap.get(nextSurname);
            for (int j = 0; j < nextOrder.size(); j++) {
                surnameSortedArray[i] = nextOrder.get(j);
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Employee[] initialArray = {new Employee("Anna", "Cho"),
                new Employee("Ella", "Go"),
                new Employee("Nana", "Cho"),
                new Employee("Jana", "Cho"),
                new Employee("Olga", "Min")};
        Employee[] surnameSortedArray = {new Employee("Anna", "Cho"),
                new Employee("Jana", "Cho"),
                new Employee("Nana", "Cho"),
                new Employee("Ella", "Go"),
                new Employee("Olga", "Min")};
        makeSortStable(initialArray, surnameSortedArray);
        for (int i = 0; i < surnameSortedArray.length; i++) {
            System.out.println(surnameSortedArray[i].surname + " " + surnameSortedArray[i].givenname);
        }
    }
}
