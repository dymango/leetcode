package app.thread;

import java.util.Objects;

/**
 * @author dimmy
 */
public class Main {

    public static void main(String[] args) {
//        new Thread(() -> new SynchronizeTest().p()).start();
//        new Thread(() -> new SynchronizeTest().p()).start();
        System.out.println(check(new Son(), new Son()));
        System.out.println(check2(Son.class, Son.class));

        Son son = new Son();
        son.name = "bana";
        new Thread(() -> {
            son.name = "apple";

            while (true) {
                System.out.println(Thread.currentThread().getName() + son.name);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            System.out.println(son.name);
            son.name = "straw";
            while (true) {
                System.out.println(Thread.currentThread().getName() + son.name);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(son.name);
        //0100
        //1000
        //1100
//        System.out.println(4 ^ 8);
//        System.out.println(12 ^ 4);
//
//        CompareUtil<Object, Object> objectObjectCompareUtil = new CompareUtil<>();
//        new Thread(() -> {
//            objectObjectCompareUtil.wait(new ArrayList<>(), new ArrayList<>());
//        }).start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        new Thread(() -> {
//            objectObjectCompareUtil.notifyObject(new ArrayList<>(), new ArrayList<>());
//        }).start();

    }

    public static <T extends Parent, C extends Parent> boolean check(T t, C c) {
        return Objects.equals(t, c);
    }

    public static boolean check2(Class<? extends Parent> t, Class<? extends Parent> c) {
        return Objects.equals(t, c);
    }
}