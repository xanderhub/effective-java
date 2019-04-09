package singleton;
/**
 * Singleton with public static final field.
 * Eager initialization
 * Thread safe
 * Not safe with deserialization / reflection
 */

public class SingletonField {

    public static final SingletonField INSTANCE = new SingletonField();

    private SingletonField() { }

}