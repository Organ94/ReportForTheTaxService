import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public class Shop {

    AtomicLong atomicLong = new AtomicLong(0);

    protected void Tax(int arraySize) {
        int[] revenue = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            revenue[i] = (int) (Math.random() * 10_000);
            atomicLong.addAndGet(revenue[i]);
        }
        System.out.println("Доход магазина " + Thread.currentThread().getName() + ": " +
                Arrays.toString(revenue));
    }
}
