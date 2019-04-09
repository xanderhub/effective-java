package singleton.reflectionproblem;

import singleton.SingletonEnum;

import java.lang.reflect.Constructor;

/**
 * This class demonstrates how the singleton property is broken with reflection,
 * when using private constructors based methods.
 */

public class ReflectionTest {
    public static void main(String[] args) throws Exception {
        SingletonReflected singleton = SingletonReflected.getInstance();

        Constructor constructor = singleton.getClass().getDeclaredConstructor();
        constructor.setAccessible(true); // Make the private constructor accessible

        SingletonReflected singleton2 = (SingletonReflected) constructor.newInstance(); // Create new instance with constructor

        if (singleton == singleton2) {
            System.out.println("Two objects are the same");
        } else {
            System.out.println("Two objects are not the same");
        }

        singleton.setValue(1);
        singleton2.setValue(2);

        System.out.println(singleton.getValue());
        System.out.println(singleton2.getValue());

    }
}
