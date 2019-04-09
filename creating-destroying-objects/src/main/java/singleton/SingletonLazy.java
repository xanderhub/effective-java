package singleton;

/**
 * Singleton with lazy initialization (double-checked lock pattern).
 * Thread safe** - there is a possibility to get NullPointerException in rare cases
 * Slow because of synchronization
 * Not safe with deserialization / reflection
 */

public class SingletonLazy {

    private static SingletonLazy INSTANCE = null;

    private SingletonLazy() { }

    public static SingletonLazy getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonLazy.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonLazy();
                }
            }
        }
        return INSTANCE;
    }

}