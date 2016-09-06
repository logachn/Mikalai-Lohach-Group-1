package com.epam.jmp;


import com.epam.jmp.model.Pupil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Pupil p1 = (Pupil) context.getBean("p1"); //by alias
        System.out.println(p1.getName());

        Pupil p2 = (Pupil) context.getBean("pupil"); //by name
        p2.setName("Bob");
        System.out.println(p2.getName());

        Pupil p3 = (Pupil) context.getBean(Pupil.class); //by type
        p3.setName("Greg");
        System.out.println(p3.getName());

        Pupil p4 = (Pupil) context.getBean("pupil", Pupil.class); //by name & type
        p4.setName("Mark");
        System.out.println(p4.getName());

    }
}
