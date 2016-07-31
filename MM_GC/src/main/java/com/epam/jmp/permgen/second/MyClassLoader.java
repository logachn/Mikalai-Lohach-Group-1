package com.epam.jmp.permgen.second;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MyClassLoader extends ClassLoader {

    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    public void invokeClassMethod(String classBinName, String methodName) {
        try {
            ClassLoader classLoader = this.getClass().getClassLoader();
            Class loadedClass = classLoader.loadClass(classBinName);
            System.out.println("Loaded class name: " + loadedClass.getName());

            Constructor constructor = loadedClass.getConstructor();
            Object classObject = constructor.newInstance();

            Method method = loadedClass.getMethod(methodName);
            System.out.println("Invoked method name: " + method.getName());
            method.invoke(classObject);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
