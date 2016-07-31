package com.epam.jmp.permgen.first;


import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

public class PermGen_oom_1 {

    private static Map<String, MyClass> map = new HashMap<String, MyClass>();
    private final static int MYI = 5000;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {


        for (int i = 0; i < MYI; i++) {
            String jar = "file:" + i + ".jar";
            URL[] url = new URL[]{new URL(jar)};

            URLClassLoader urlClassLoader = new URLClassLoader(url);

            MyClass t = (MyClass) Proxy.newProxyInstance(urlClassLoader,
                    new Class[]{MyClass.class},
                    new MyClassInvokationHandler(new MyClassImpl()));

            map.put(jar, t);

            Thread.sleep(1);
        }
    }
}

