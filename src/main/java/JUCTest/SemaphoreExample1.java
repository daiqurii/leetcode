package JUCTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample1 {
    private static final int threadCount = 550;

    public static void main(String[] args) {
        // 创建一个具有固定线程数量的线程池对象（如果这里线程池的线程数量给太少的话你会发现执行的很慢）
        ExecutorService threadPool = Executors.newFixedThreadPool(300);
        //一次能允许执行的线程数量 20
        final Semaphore semaphore = new Semaphore(20,true);

        for(int i = 0;i<threadCount;i++){
            final int threadnum = i;
            threadPool.execute(()->{
                try {
                    //拿走一个许可证就少一个 需要等待release才能继续 用于限制获取某种资源的线程数量
                    semaphore.acquire();
                    test(threadnum);
                    semaphore.release();// 释放一个许可
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
        System.out.println("finish");
    }
    public static void test(int threadnum) throws InterruptedException {
        //通过sleep模拟耗时的请求操作
        Thread.sleep(1000);
        System.out.println("threadnum"+threadnum);
        Thread.sleep(1000);
    }
}
