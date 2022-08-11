package JUCTest;

public class ThreadLocalExample1 {
    private static final ThreadLocal<Integer> num = ThreadLocal.withInitial(()->new Integer(1));
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(()->{
                num.set(finalI+10);
            }).start();
        }
        System.out.println(num.get());
    }
}
