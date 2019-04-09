package singleton;

import java.io.Serializable;

/**
 * Singleton with lazy initialization (initialization on demand holder pattern).
 * Thread safe
 * Fast
 * Not safe with deserialization / reflection
 */

public class SingletonLazyWithHolder {

    private SingletonLazyWithHolder() {}

    private static class SingletonHolder {
        public static final SingletonLazyWithHolder INSTANCE = new SingletonLazyWithHolder();
    }

    public static SingletonLazyWithHolder getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
