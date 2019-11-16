package pattern.singleton.hungry.test;

import pattern.singleton.hungry.simple.Hungry;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Tom on 2018/3/7.
 */
public class ThreadSafeTest {


    public static void main(String[] args) {
            int count =100;
        CountDownLatch latch = new CountDownLatch(count);

        final Set<Hungry> set = Collections.synchronizedSet(new HashSet<>());

//CountDownLatch 是类似计数器，await()方法作用是等待计数器变0，所有线程一起执行，之前的都暂时阻塞。
        for(int i=0;i<count;i++){
            new Thread(){
                @Override
                public void run() {
                    latch.countDown();
                    Hungry.getInstance();
                }
            }.start();
        }
        try{
            System.out.println(latch.getCount());
            latch.await();
            System.out.println("await到0了");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
