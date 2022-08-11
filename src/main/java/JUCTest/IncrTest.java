package JUCTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IncrTest {
    public static volatile int num = 0;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for(int j = 0;j<10;j++){
            threadPool.execute(()->{
                for (int i = 0; i < 250; i++) {
                    incr();
                }
            });
        }
        Thread.sleep(1500);
        System.out.println(num);
        threadPool.shutdown();
    }
    public static void incr(){
        num++;
    }
}
