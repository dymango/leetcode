package app.ibmprepare;

import java.util.concurrent.atomic.LongAdder;

/**
 * @author dimmy
 */
public class SyncUtil {
    public static LongAdder count = new LongAdder();
    public final Object lock = new Object();
    public Object lock2 = new Object();

    public void printA() {
        synchronized(SyncUtil.class) {
            count.increment();
            if(count.intValue() > 3) return;
            System.out.println("A" +count.intValue());
//            printA();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public  void printB() {
        synchronized(SyncUtil.class) {
            System.out.println("B");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SyncUtil syncUtil = new SyncUtil();
        new Thread(syncUtil::printA).start();
        new Thread(syncUtil::printB).start();
    }
}
