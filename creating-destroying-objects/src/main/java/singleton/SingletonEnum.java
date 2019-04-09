package singleton;

/**
 * The best method for creating singletons in java.
 * Singleton property is 100% guaranteed.
 *
 * Thread safe by definition
 * Serializable by definition (@Note:  when serializing an enum, field variables are not get serialized)
 * Reflection is not relevant for enums
 */

public enum SingletonEnum {
    INSTANCE;

    /*  ---------  Singleton body -----------  */

    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
