package ru.job4j.ood.ocp.violation;

import ru.job4j.ood.srp.model.Employee;
import java.util.ArrayList;
import java.util.List;

public class BankDB extends EmployerDB {
    List<Employee> banker = new ArrayList<>();

    @Override
    public void add(Employee em) {
        banker.add(em);
    }

    /*
    Возвращаемые типы методов
    должны быть абстракциями.
    Таким образом Нарушение OCP.
    */
    public ArrayList<Employee> getAllExperienced() {
        return new ArrayList<>(banker);
    }
}
