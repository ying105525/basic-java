package pattern.singleton.lazy.test;

import pattern.singleton.lazy.simple.LazyOne;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Tom on 2018/3/7.
 */
public class ThreadSafeTest {


    public static void main(String[] args) throws InterruptedException {
        int count =100;
        CountDownLatch latch = new CountDownLatch(count);


//CountDownLatch 是类似计数器，await()方法作用是等待计数器变0，所有线程一起执行，之前的都暂时阻塞。
        for(int i=0;i<count;i++){
//            new Thread(){
//                @Override
//                public void run() {
//                    try{
//                        System.out.println("当前计数器为："+latch.getCount());
//                        latch.await();
//                        Object obj = LazyOne.getInstance();
//                        System.out.println(System.currentTimeMillis()+":"+obj);
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }
//                }
//            }.start();
            new Thread(){
                @Override
                public void run() {
                    try{
                        System.out.println("当前计数器为："+latch.getCount());
                        latch.countDown();
                        Object obj = LazyOne.getInstance();
                        System.out.println(System.currentTimeMillis()+":"+obj);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }.start();
        }
        latch.await();
        System.out.println("over");
    }

}
