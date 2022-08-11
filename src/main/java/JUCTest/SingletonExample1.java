package JUCTest;

public class SingletonExample1 {
    public SingletonExample1() {
    }
    //需要避免初始化和分配内存空间的重排序
    //多线程环境下会导致一个线程获得还没有初始化的实例。
    private static volatile SingletonExample1 singleton;
    /*public SingletonExample1 getSingleton(){
        //懒汉单例

        if(singleton == null) singleton = new SingletonExample1();
        return singleton;
    }*/

    public static SingletonExample1 getSingleton(){
        if(singleton == null){
            synchronized (SingletonExample1.class){
                if(singleton == null){
                    singleton = new SingletonExample1();
                }
            }
        }
        return singleton;

    }
}
