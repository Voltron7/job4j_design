package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.CurrencyConverter;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import static org.assertj.core.api.Assertions.assertThat;

class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        Report engine = new ReportEngine(store, parser);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(parser.parse(worker.getHired())).append(" ")
                .append(parser.parse(worker.getFired())).append(" ")
                .append(worker.getSalary())
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }

    @Test
    public void whenBookkeepingGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        CurrencyConverter currencyConverter = new InMemoryCurrencyConverter();
        store.add(worker);
        Report engine = new ReportForBookkeeping(store, parser, currencyConverter);
        double convertedSalary = currencyConverter.convert(Currency.RUB, worker.getSalary(), Currency.EUR);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(parser.parse(worker.getHired())).append(" ")
                .append(parser.parse(worker.getFired())).append(" ")
                .append(convertedSalary)
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }

    @Test
    public void whenHRGenerated() {
        MemStore store = new MemStore();
        Employee worker1 = new Employee("Ivan", 100);
        Employee worker2 = new Employee("Alex", 700);
        Employee worker3 = new Employee("Hugo", 300);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engine = new ReportForHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(" ")
                .append(worker2.getSalary())
                .append(System.lineSeparator())
                .append(worker3.getName()).append(" ")
                .append(worker3.getSalary())
                .append(System.lineSeparator())
                .append(worker1.getName()).append(" ")
                .append(worker1.getSalary())
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }

    @Test
    public void whenProgrammersGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        Report engine = new ReportForProgrammers(store, parser);
        StringBuilder expect = new StringBuilder()
                .append("Name;Hired;Fired;Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(parser.parse(worker.getHired())).append(";")
                .append(parser.parse(worker.getFired())).append(";")
                .append(worker.getSalary())
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }

    @Test
    public void whenJSONGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        Report engine = new ReportJSON(store, parser);
        StringBuilder expect = new StringBuilder();
        expect.append("[")
                .append("{").append("\"name\":\"").append(worker.getName()).append("\",")
                .append("\"hired\":{").append("\"year\":").append(worker.getHired()
                        .get(Calendar.YEAR)).append(",")
                .append("\"month\":").append(worker.getHired()
                        .get(Calendar.MONTH)).append(",")
                .append("\"dayOfMonth\":").append(worker.getHired()
                        .get(Calendar.DAY_OF_MONTH)).append(",")
                .append("\"hourOfDay\":").append(worker.getHired()
                        .get(Calendar.HOUR_OF_DAY)).append(",")
                .append("\"minute\":").append(worker.getHired()
                        .get(Calendar.MINUTE)).append(",")
                .append("\"second\":").append(worker.getHired()
                        .get(Calendar.SECOND)).append("},")
                .append("\"fired\":{").append("\"year\":").append(worker.getFired()
                        .get(Calendar.YEAR)).append(",")
                .append("\"month\":").append(worker.getFired()
                        .get(Calendar.MONTH)).append(",")
                .append("\"dayOfMonth\":").append(worker.getFired()
                        .get(Calendar.DAY_OF_MONTH)).append(",")
                .append("\"hourOfDay\":").append(worker.getFired()
                        .get(Calendar.HOUR_OF_DAY)).append(",")
                .append("\"minute\":").append(worker.getFired()
                        .get(Calendar.MINUTE)).append(",")
                .append("\"second\":").append(worker.getFired()
                        .get(Calendar.SECOND)).append("},")
                .append("\"salary\":").append(worker.getSalary()).append("}")
                .append("]");
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }

    @Test
    public void whenXMLGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Report engine = new ReportXML(store);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .append("\n<Employees>\n")
                .append("    <employees>\n")
                .append("        <employee>\n")
                .append("            <fired>").append(dateFormat.format(worker.getFired().getTime()))
                .append("</fired>\n")
                .append("            <hired>").append(dateFormat.format(worker.getHired().getTime()))
                .append("</hired>\n")
                .append("            <name>").append(worker.getName())
                .append("</name>\n")
                .append("            <salary>").append(worker.getSalary())
                .append("</salary>\n")
                .append("        </employee>\n")
                .append("    </employees>\n")
                .append("</Employees>\n");
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}