import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Shop {

    protected static LongAdder longAdder = new LongAdder();

    protected void tax(int arraySize) {
        int[] revenue = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            revenue[i] = (int) (Math.random() * 10_000);
            longAdder.add(revenue[i]);
        }
        System.out.println("Доход магазина " + Thread.currentThread().getName() + ": " +
                Arrays.toString(revenue));
    }
}
