package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        final Person person = new Person(false, 30,
                new Contact("11-111"), new String[]{"Worker", "Married"});
        System.out.println(person);

        final Cat cat = new Cat("Milo", false, 7,
                new Contact("33-333"), new String[]{"Male, Blooded"});
        System.out.println(cat);

        JAXBContext context = JAXBContext.newInstance(Cat.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(cat, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Cat result = (Cat) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
