package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;
import java.util.List;
import java.util.function.Predicate;

public class ReportJSON implements Report {
    private final Store store;
    private final Gson gson;


    public ReportJSON(Store store) {
        this.store = store;
        this.gson = new GsonBuilder().create();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> sortedEmployee = store.findBy(filter);
        return gson.toJson(sortedEmployee);
    }
}
