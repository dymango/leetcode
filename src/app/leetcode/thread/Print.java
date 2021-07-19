package app.leetcode.thread;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dimmy
 */
public class Print {

    private Integer n = 1;
    private ReentrantLock lock;
    private Condition condition;
    public Thread A;
    public Thread B;

    {
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    public synchronized void a() {
        LockSupport.setCurrentBlocker(this);
        System.out.println("start a");
        LockSupport.park();
        System.out.println(Thread.currentThread().isInterrupted());
        int count = 0;
        while (count++ != 10) {
            lock.lock();
            System.out.println("a");
            condition.signal();
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }
        LockSupport.unpark(Thread.currentThread());
        LockSupport.setCurrentBlocker(null);
    }


    public void b() {
        LockSupport.setCurrentBlocker(this);
        LockSupport.park();
        System.out.println("start b");
        int count = 0;
        while (count++ != 10) {
            lock.lock();
            System.out.println("b");
            condition.signal();
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Field field = Print.class.getDeclaredField("n");
                Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
                theUnsafe.setAccessible(true);
                Unsafe unsafe = (Unsafe) theUnsafe.get(null);
                unsafe.compareAndSwapInt(count, unsafe.objectFieldOffset(field), 1, 3);
                System.out.println(n);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            lock.unlock();
        }
        LockSupport.setCurrentBlocker(null);
    }

    private void lockSupportVersionA() {
        int count = 0;
        while (count++ != 10) {
            System.out.println("ls A");
            LockSupport.unpark(B);
            LockSupport.park();
        }
    }

    private void lockSupportVersionB() {
        int count = 0;
        while (count++ != 10) {
            LockSupport.park();
            System.out.println("ls B");
            LockSupport.unpark(A);
        }
    }

    public static void main(String[] args) {
        Print print = new Print();
        print.A = new Thread(print::lockSupportVersionA);
        print.B = new Thread(print::lockSupportVersionB);
        print.A.start();
        print.B.start();
    }
}
