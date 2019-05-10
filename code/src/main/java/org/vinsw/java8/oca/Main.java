package org.vinsw.java8.oca;

public class Main {
//
//    public static void main(String[] args) {
//        Jumpable var = new Lion();
//        Animal var1 = new Animal();
//
//        //    Lion lion = new Animal();//error
//        //        Jumpable var3 = new Jumpable(); // error
//        //        Jumpable var1 = new Animal(); // compil error
//        //        Jumpable var2 = (Jumpable) (new Animal());  // runtime error
//    }

//    public static void main(String[] args) {
//        int a = 10; String name = null;
//        try {
//            a = name.length();
//            a++;
//        } catch (NullPointerException e){
//            ++a;
//            return;
//        } catch (RuntimeException e){
//            a--;
//            return;
//        } finally {
//            System.out.println(a);
//        }
//    }

    public static void main(String[] args) {
        String s1 ="Java";
        String s2 ="Java";
        StringBuffer sb1 = new StringBuffer();
        sb1.append("Ja").append("va");

        System.out.println(s1 == s2);                   //true
        System.out.println(s1.equals(s2));              //true
        System.out.println(s1 == sb1.toString());       //false, refers to different object
        System.out.println(s1.equals(sb1.toString()));  //true

    }

}
