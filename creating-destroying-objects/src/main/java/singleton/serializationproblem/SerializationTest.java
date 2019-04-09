package singleton.serializationproblem;

import java.io.*;

/**
 * This class demonstrates how the singleton property is broken with deserialization,
 * when using private constructors based methods.
 */
public class SerializationTest implements Serializable {

    public static void main(String[] args) {
        SingletonSerializable_NotSafe singletonNotSafe = SingletonSerializable_NotSafe.getInstance();
        SingletonSerializable_Safe singletonSafe = SingletonSerializable_Safe.getInstance();
        singletonNotSafe.setValue(1);
        singletonSafe.setValue(1);

        // Serialize the singletons with value = 1
        try {
            FileOutputStream fileOut = new FileOutputStream("out.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(singletonNotSafe);
            out.writeObject(singletonSafe);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        singletonNotSafe.setValue(2); // Change the value of the singleton in memory to 2
        singletonSafe.setValue(2); // Change the value of the singleton in memory to 2

        // Deserialize the serialized singleton with value 1
        SingletonSerializable_NotSafe singletonNotSafe2 = null;
        SingletonSerializable_Safe singletonSafe2 = null;
        try {
            FileInputStream fileIn = new FileInputStream("out.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            singletonNotSafe2 = (SingletonSerializable_NotSafe) in.readObject();
            singletonSafe2 = (SingletonSerializable_Safe) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("singletons.SingletonEnum class not found");
            c.printStackTrace();
        }

        if (singletonNotSafe == singletonNotSafe2) {
            System.out.println("Two objects are the same");
        } else {
            System.out.println("Two objects are not the same");
        }

        System.out.println(singletonNotSafe.getValue());
        System.out.println(singletonNotSafe2.getValue());

        //-------------Check safe serialization now:

        if (singletonSafe == singletonSafe2) {
            System.out.println("Two objects are the same");
        } else {
            System.out.println("Two objects are not the same");
        }

        System.out.println(singletonSafe.getValue());
        System.out.println(singletonSafe2.getValue());

    }

}