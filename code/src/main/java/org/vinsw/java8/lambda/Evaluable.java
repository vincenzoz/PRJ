package org.vinsw.java8.lambda;

/**
 * This is a functional class, it could contains only one abstract method
 */
@FunctionalInterface
public interface Evaluable {

    void eval(int a, int b);

    /**
     * A default method can be part of the interface
     */
    default void normalFun()
    {
        System.out.println("This is a normal function");
    }
}
