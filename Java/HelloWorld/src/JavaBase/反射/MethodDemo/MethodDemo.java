package JavaBase.反射.MethodDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.StringJoiner;

public class MethodDemo {
    public static void main(String[] args) {
//        String s = "Hello World";
//        System.out.println(s.substring(6));
//        try {
//            Method method = String.class.getMethod("substring", int.class);
//            System.out.println(method.invoke(s, 6));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(Integer.parseInt("123"));
//        try {
//            Method method = Integer.class.getMethod("parseInt", String.class);
//            System.out.println(method.invoke(null, "123456"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String s = new String();
        try {
            Class<String> s = newInstance(String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    static <T>  T newInstance(T name) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = name.getClass().getConstructor(name.getClass());
        return (T) constructor.newInstance();
    }
}
