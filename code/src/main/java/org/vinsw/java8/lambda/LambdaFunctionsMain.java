package org.vinsw.java8.lambda;

public class LambdaFunctionsMain {

    public static void main(String[] args) {
        customFunction();
    }


    static void customFunction() {
        System.out.println("customFunction(..)");

        Evaluable ev = (int val1, int val2) -> {
            int max = Math.max(val1, val2);
            System.out.println(max);
        };
        ev.eval(20, 15);
    }

}
