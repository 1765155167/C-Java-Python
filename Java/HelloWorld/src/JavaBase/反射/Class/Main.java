package JavaBase.反射.Class;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args)  {
        try {
            getAndSetName(new Person("Ming"));
            // String对象:
            String s = "Hello world";
            // 获取String substring(int)方法，参数为int:
            Method m = String.class.getMethod("substring", int.class);
            // 在s对象上调用该方法并获取结果:
            String r = (String) m.invoke(s, 6);
            // 打印调用结果:
            System.out.println(r);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    static void getAndSetName(Object obj)
            throws NoSuchFieldException, IllegalAccessException{
        Class cls = obj.getClass();
        Field field = cls.getDeclaredField("name");
        field.setAccessible(true);
        field.set(obj, "胡秋峰");
        System.out.println(field.get(obj));
    }

    static void printClassInfoTest() {
        printClassInfo("".getClass());
        printClassInfo(Runnable.class);
        printClassInfo(java.time.Month.class);
        printClassInfo(String[].class);
        printClassInfo(int.class);
    }

    static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
    }
}

class Student extends Person {
    public int score;
    private int grade;

    public Student(String name) {
        super(name);
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }
}