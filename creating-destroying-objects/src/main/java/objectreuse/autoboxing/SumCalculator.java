package objectreuse.autoboxing;

/**
 * prefer primitives to
 * boxed primitives, and watch out for unintentional autoboxing
 */
public class SumCalculator {

    private static long sumUsingPrimitives() {
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }

    /**
     * this method constructs 2^31 unnecessary
     * Long instances (because of the boxing)
     */
    private static long sumUsingBoxing() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }



    public static void main(String[] args) {
        long startTime = System.nanoTime();
        sumUsingBoxing();
        long endTime = System.nanoTime();

        System.out.println("Execution time using boxed primitives in seconds : " +
                (double)(endTime - startTime) / 1_000_000_000);

        startTime = System.nanoTime();
        sumUsingPrimitives();
        endTime = System.nanoTime();

        System.out.println("Execution time using primitives in seconds : " +
                (double)(endTime - startTime) / 1_000_000_000);

    }
}
