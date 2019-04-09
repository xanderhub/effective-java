package singleton;

/**
 * Singleton with static factory method.
 * Eager initialization
 * Thread safe
 * Not safe with deserialization / reflection
 */
public class SingletonFactory {

    private static final SingletonFactory INSTANCE = new SingletonFactory();

    private SingletonFactory() { }

    public static SingletonFactory getInstance() {
        return INSTANCE;
    }
}