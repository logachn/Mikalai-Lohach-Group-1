package com.epam.jmp.permgen.second;


public class PermGen_oom_2 {

    public static void main(String[] args) throws Exception {
        Thread.sleep(1);
        MyClassLoader loader = new MyClassLoader(ClassLoader.getSystemClassLoader());
        loader.invokeClassMethod("com.epam.jmp.permgen.second.another.pack.Cat", "show");
    }

}
