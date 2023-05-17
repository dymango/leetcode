package app.bean;

/**
 * @author dimmy
 */
public class NestBean {

    public static class A {
        public B b;

        public void exec() {
            System.out.println("A exec");
            b.exec();
        }
    }

    public static class B {
        public A a;

        public void exec() {
            System.out.println("B exec");
            a.exec();
        }
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.b = b;
        b.a = a;
        a.exec();
    }
}
