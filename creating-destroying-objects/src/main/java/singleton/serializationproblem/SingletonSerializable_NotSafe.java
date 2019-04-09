package singleton.serializationproblem;

import java.io.Serializable;

/**
 * Singleton with static factory method.
 * Eager initialization
 * Thread safe
 * Not safe with deserialization / reflection
 */

public class SingletonSerializable_NotSafe implements Serializable {

    private static final SingletonSerializable_NotSafe INSTANCE = new SingletonSerializable_NotSafe();

    private SingletonSerializable_NotSafe() { }

    public static SingletonSerializable_NotSafe getInstance() {
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
