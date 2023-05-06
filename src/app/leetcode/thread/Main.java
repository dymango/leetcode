package app.leetcode.thread;

/**
 * @author dimmy
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
//        Foo foo = new Foo();
        Runnable runnable = () -> System.out.println(1);
        Runnable runnable2 = () -> System.out.println(2);
        Runnable runnable3 = () -> System.out.println(3);
//        new Thread(() -> {
//            try {
//                foo.first(runnable);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(() -> {
//            try {
//                foo.second(runnable2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(() -> {
//            try {
//                foo.third(runnable3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();

        FooBar fooBar = new FooBar(3);
        new Thread(() -> {
            try {
                fooBar.foo(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fooBar.bar(runnable2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
//
//        FizzBuzz fizzBuzz = new FizzBuzz(15);
//        new Thread(() -> {
//            try {
//                fizzBuzz.buzz(()-> System.out.println("buzz"));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//        new Thread(() -> {
//            try {
//                fizzBuzz.fizz(()-> System.out.println("fizz"));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(() -> {
//            try {
//                fizzBuzz.fizzbuzz(()-> System.out.println("FB"));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//        new Thread(() -> {
//            try {
//                fizzBuzz.number(value -> System.out.println(value));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();


    }
}
