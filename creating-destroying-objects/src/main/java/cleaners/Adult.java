package cleaners;

/**
 * Adult class uses try-with-resource block => automatic cleaning is not required
 */
public class Adult {
    public static void main(String[] args) {
        try (Room myRoom = new Room(7)) {
            System.out.println("Goodbye");
        }
    }
}
