package ru.job4j.ood.ocp.violation;

import ru.job4j.ood.srp.model.Employee;
import java.util.ArrayList;
import java.util.List;

public class EmployerDB {
    private List<Employee> employees = new ArrayList<>();

    public void add(Employee em) {
        employees.add(em);
    }

    public void delete(Employee em) {
        employees.remove(em);
    }
}
