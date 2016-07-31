package com.epam.jmp.permgen.second.another.pack;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Calendar;

public class Cat extends Feline {

    public Cat() {
        super(3, 3);
        System.out.println("hello from cat");
    }

    public void show() throws IOException {

        System.out.println("2");
        for (int i = 0; i < 500000; i++) {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(Calendar.getInstance());
            oos.close();
        }

    }


}
