package cleaners;


import java.lang.ref.Cleaner;

/**
 * Try not to use cleaners except as a safety net
 * or to terminate noncritical native resources.
 * No guarantees are made relating to whether cleaning actions are invoked or not
 *
 * Room’s cleaner is used only as a safety net. If clients
 * surround all Room instantiations in try-with-resource blocks, automatic
 * cleaning will never be required (see Adult and Teenager classes)
 * */
public class Room implements AutoCloseable {
    private static final Cleaner cleaner = Cleaner.create();

    // Resource that requires cleaning. Must not refer to Room!
    private static class State implements Runnable {
        int numJunkPiles; // Number of junk piles in this room

        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        // Invoked by close method or cleaner
        @Override
        public void run() {
            System.out.println("Cleaning room");
            numJunkPiles = 0;
        }
    }

    // The state of this room, shared with our cleanable
    private final State state;
    // Our cleanable. Cleans the room when it’s eligible for gc
    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }

    @Override
    public void close() {
        cleanable.clean();
    }
}
