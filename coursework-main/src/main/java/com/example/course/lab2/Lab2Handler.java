package com.example.course.lab2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Random;

public class Lab2Handler {
    public static String start() {
        StringBuilder result = new StringBuilder();
        for (Method m : MyClass.class.getDeclaredMethods()) {
            if ((Modifier.isPrivate(m.getModifiers()) || Modifier.isProtected(m.getModifiers())) && m.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation annotation = m.getAnnotation(MyAnnotation.class);
                m.setAccessible(true);
                for (int j = 0; j < annotation.value(); j++) {
                    try {
                        Object[] parameters = getParametersForMethod(m);
                        result.append(m.invoke(null, parameters));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
                m.setAccessible(false);
            }
        }
        return result.toString();
    }

    public static Object[] getParametersForMethod(Method m) {
        Object[] params = new Object[m.getParameterCount()];
        for (int i = 0; i < params.length; ++i) {
            if (m.getParameterTypes()[i].equals(int.class)) {
                params[i] = new Random().nextInt(10);
            } else if (m.getParameterTypes()[i].equals(double.class)) {
                params[i] = new Random().nextDouble(10);
            } else if (m.getParameterTypes()[i].equals(boolean.class)) {
                params[i] = new Random().nextBoolean();
            } else if (m.getParameterTypes()[i].equals(char.class)) {
                params[i] = new Random().nextInt(26) + 'A';
            } else if (m.getParameterTypes()[i].equals(float.class)) {
                params[i] = new Random().nextFloat(10);;
            } else if (m.getParameterTypes()[i].equals(byte.class)) {
                params[i] = (byte) new Random().nextInt(10);;
            } else {
                params[i] = "Random string";
            }
        }
        return params;
    }
}




