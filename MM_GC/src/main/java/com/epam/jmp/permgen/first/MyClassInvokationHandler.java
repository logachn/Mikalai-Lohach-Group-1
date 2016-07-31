package com.epam.jmp.permgen.first;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class MyClassInvokationHandler implements InvocationHandler {
    public MyClassInvokationHandler(MyClassImpl myClass) {

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
