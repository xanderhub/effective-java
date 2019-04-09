package singleton.solution;

import singleton.SingletonEnum;

/**
 * This class provides an demonstration of how to use singletons with enums.
 */

public class SingletonEnumDemo {
    public static void main(String[] args) {
        SingletonEnum singleton1 = SingletonEnum.INSTANCE;
        SingletonEnum singleton2 = SingletonEnum.INSTANCE;

        System.out.println(singleton1.getValue());
        System.out.println(singleton2.getValue());
        singleton1.setValue(2);
        System.out.println(singleton1.getValue());
        System.out.println(singleton2.getValue());
    }
}
