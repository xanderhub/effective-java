package singleton.serializationproblem;

import java.io.Serializable;

/**
 * Singleton with static factory method.
 * Eager initialization
 * Thread safe
 * Safe with deserialization.
 * Not safe with reflection
 */

public class SingletonSerializable_Safe implements Serializable {

    private static final SingletonSerializable_Safe INSTANCE = new SingletonSerializable_Safe();

    private SingletonSerializable_Safe() { }

    public static SingletonSerializable_Safe getInstance() {
        return INSTANCE;
    }

/**
 *     implement the readResolve method which is called
 *     when preparing the deserialized object before returning it to the caller
 */
    protected Object readResolve() {
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
