package singleton.reflectionproblem;

/**
 * Singleton with static factory method.
 * Eager initialization
 * Thread safe
 * Not safe with deserialization / reflection
 */
public class SingletonReflected {

    private static final SingletonReflected INSTANCE = new SingletonReflected();

    private SingletonReflected() { }

    public static SingletonReflected getInstance() {
        return INSTANCE;
    }



    /*  ---------  Singleton body -----------  */

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
