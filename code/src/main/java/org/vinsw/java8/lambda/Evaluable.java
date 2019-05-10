package org.vinsw.java8.lambda;

/**
 * This is a functional class, it could contains only one abstract method
 */
@FunctionalInterface
public interface Evaluable {

    int eval(int a, int b);

    boolean equals(Object a); // This method is not abstract in that exists an implementation in th Object.java class
    /**
     * A default method can be part of the interface
     */
    default void normalFun()
    {
        System.out.println("This is a normal function");
    }
}
