package com.company;

public class Child  extends Perant{
    int age;

    public void write(){
        System.out.println(height);
        System.out.println(weight);
        System.out.println("write letters");
    }
    

    public Child(int age, int height) {
        this.age = age;
        this.height= height;
        System.out.println("age "+ age);
        System.out.println("height "+height);

    }
}
