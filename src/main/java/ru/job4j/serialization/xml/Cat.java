package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "cat")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cat {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private boolean isSterilized;
    @XmlAttribute
    private int age;
    private Contact contact;
    @XmlElementWrapper(name = "infos")
    @XmlElement(name = "info")
    private String[] infos;

    public Cat() {
    }

    public Cat(String name, boolean isSterilized, int age, Contact contact, String[] infos) {
        this.name = name;
        this.isSterilized = isSterilized;
        this.age = age;
        this.contact = contact;
        this.infos = infos;
    }

    @Override
    public String toString() {
        return "Cat{"
                + "name='" + name + '\''
                + ", isSterilized=" + isSterilized
                + ", age=" + age
                + ", contact=" + contact
                + ", infos=" + Arrays.toString(infos)
                + '}';
    }
}
