package ru.job4j.ood.srp.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeesList {

    @XmlElementWrapper(name = "employees")
    @XmlElement(name = "employee")
    private List<Employee> employees;

    public EmployeesList() {
    }

    public EmployeesList(List<Employee> employees) {
        this.employees = employees;
    }
}
