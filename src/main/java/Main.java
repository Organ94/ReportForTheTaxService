import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int NUMBER_OF_STORES = 3;
    private static final int ARRAY_SIZE = 5;

    public static void main(String[] args) throws InterruptedException {
        Shop shop = new Shop();

        List<Thread> shopList = creatingStores(NUMBER_OF_STORES, ARRAY_SIZE, shop);
        for (Thread s : shopList) {
            s.join();
        }
        System.out.println("Выручка всех магазинов за " + ARRAY_SIZE + " дней: " + shop.longAdder.sum());
    }

    private static List<Thread> creatingStores(int numberOfStores, int arraySize, Shop shop) {
        List<Thread> shopList = new ArrayList<>();
        for (int i = 0; i < numberOfStores; i++) {
            shopList.add(new Thread(null, () -> shop.tax(arraySize), "Shop-" + i));
            shopList.get(i).start();
        }
        return shopList;
    }
}
