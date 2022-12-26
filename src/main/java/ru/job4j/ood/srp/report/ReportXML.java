package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.EmployeesList;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.function.Predicate;

public class ReportXML implements Report {
    private final Store store;
    private final JAXBContext context;
    private final Marshaller marshaller;

    public ReportXML(Store store) throws JAXBException {
        this.store = store;
        this.context = JAXBContext.newInstance(EmployeesList.class);
        this.marshaller = context.createMarshaller();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String xml;
        try {
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        try (StringWriter writer = new StringWriter()) {
                marshaller.marshal(new EmployeesList(store.findBy(filter)), writer);
                xml = writer.getBuffer().toString();
            }
        } catch (IOException | JAXBException e) {
            throw new IllegalArgumentException();
        }
        return xml;
    }
}
