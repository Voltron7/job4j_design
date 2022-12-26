package ru.job4j.ood.ocp.violation;

import ru.job4j.ood.srp.model.Employee;
import java.util.List;

public class AddData {

    /*
    Поля должны представлять тип абстракций.
    Такой вариант может привести к сложностям
    расширения и этот класс придется изменять.
    */
    private List<Employee> employees;

    public void add(Employee em) {
        employees.add(em);
    }
}
