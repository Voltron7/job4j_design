package ru.job4j.ood.lsp.violation;

import ru.job4j.ood.srp.model.Employee;

public class TopSalary {
    protected Employee employee;

    public TopSalary(Employee employee) {
        validate(employee);
        this.employee = employee;
    }

    protected void validate(Employee employee) {
        if (employee.getSalary() < 7777) {
            throw new IllegalArgumentException("Salary is not enough!");
        }
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        validate(employee);
        this.employee = employee;
    }

    public class CoderSalary extends TopSalary {

        public CoderSalary(Employee employee) {
            super(employee);
        }

        /*
        Нарушение LSP, так как все условия базового класса
        также должны быть сохранены и в подклассе.
        */
        @Override
        public void setEmployee(Employee employee) {
            /* some specific logic; */
            /* Забыли сделать проверку. Возможно не валидное состояние */
            this.employee = employee;
        }
    }
}
