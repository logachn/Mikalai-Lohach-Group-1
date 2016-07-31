package com.epam.jmp.permgen.second.another.pack;


class Feline extends Animal {

    int a = 5;
    int b = 6;

    Feline(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    void method() {
        System.out.println("1");
    }
}
