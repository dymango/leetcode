package interview.experience.pdd;

import app.generic.Fruit;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dimmy
 */
public class CompareUtil<T, C> {
    public ReentrantLock reentrantLock = new ReentrantLock();
    public Condition condition = reentrantLock.newCondition();

    public void wait(List<T> list, List<C> list2) {
        reentrantLock.lock();
        try {
            condition.await();
            System.out.println("wait");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            reentrantLock.unlock();
        }
    }

    public void notifyObject(List<T> list, List<C> list2) {
        reentrantLock.lock();
        condition.signal();
        reentrantLock.unlock();
        System.out.println("notify");
    }

    public <W extends Fruit, V extends Fruit> boolean compare(List<W> t, List<V> v) {
        return true;
    }

    public boolean compareV2(List<? extends Fruit> fruits, List<? extends Fruit> fruits2) {
        if (fruits == null) throw new IllegalArgumentException();
        return false;
    }


    public static void main(String[] args) {
        CompareUtil<Object, Object> objectObjectCompareUtil = new CompareUtil<>();
        objectObjectCompareUtil.exec();
//        new Thread(() -> {
//            objectObjectCompareUtil.wait(new ArrayList<>(), new ArrayList<>());
//        }).start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        objectObjectCompareUtil.notifyObject(new ArrayList<>(), new ArrayList<>());

    }

    public void exec() {
        try {
            throw new IllegalArgumentException("error");
        } finally {
            System.out.println("finally");
        }
    }
}
