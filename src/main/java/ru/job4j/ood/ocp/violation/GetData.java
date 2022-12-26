package ru.job4j.ood.ocp.violation;

import ru.job4j.ood.srp.model.Employee;
import java.util.List;

public class GetData {

    /*
    Возвращаемые типы мнтодов и типы
    параметров должны быть абстракциями.
    Таким образом Нарушение OCP.
    */
    private List<Employee> employees;

    public Employee get(Employee em) {
        return em;
    }
}
