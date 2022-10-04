package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        LOG.debug("User info name : {}, age : {}", name, age);

        byte b = 7;
        short s = 777;
        int i = 77777;
        long l = 777777L;
        float f = 7777.7F;
        double d = 777.77D;
        boolean rsl = false;
        char c = 'x';
        LOG.debug("Primitive variables info : b = {}, s = {}, i = {}, l = {}, f = {}, d = {}, rsl = {}, c = {} ",
                b, s, i, l, f, d, rsl, c);
    }
}
