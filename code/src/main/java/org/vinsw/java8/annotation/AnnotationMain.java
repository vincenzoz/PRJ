package org.vinsw.java8.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class AnnotationMain {

    public static void main(String[] args) {

        SimpleObject so = new SimpleObject();

        checkAllAnnotation(so);
        checkValidQualifier(so.getClass());

    }

    private static boolean checkValidQualifier(Class qualifierClass) {
        if (qualifierClass.isAnnotationPresent(Datasource.class)) { //Check if the annotation is present at class level
            System.out.println("This object is a Datasource");
            return true;
        }
        return false;
    }

    private static void checkAllAnnotation(Object obj) {

        Class<?> clazz = obj.getClass();

        List<Method> methods = Arrays.asList(clazz.getDeclaredMethods());
        for (Method m : methods) {
            for (Annotation an : m.getDeclaredAnnotations()) {
                System.out.println(an.annotationType().getSimpleName());
            }
        }

        for (Field fields : Arrays.asList(clazz.getFields())) {
            for (Annotation an : fields.getDeclaredAnnotations()) {
                System.out.println(an.annotationType().getSimpleName());
                if (an instanceof Configuration) {
                    String path = ((Configuration) an).path();
                    System.out.println("\n Found Configuration - Path: " + path);
                }
            }
        }

    }

//    private static Set validQualifiers() {
//        Class[] validAnnotations = {Configuration.class, Datasource.class};
//        return new HashSet(Arrays.asList(validAnnotations));
//    }
}
