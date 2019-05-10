package org.vinsw.java8.oca.inheritance;

public class FirstSubclass extends BaseAbstractClass {

    @Override
    public void send() {
        System.out.println("FirstSubclass send()");
    }

    // COMPILE ERROR due to same method name even if different return type
//    public void sameMethodName() {
//
//    }
//
//    public int sameMethodName() {
//
//    }

    //This static method is accessible from SecondSubclass that extend this class
    static void getFirstSubclassStaticMehod() {

    }
}
