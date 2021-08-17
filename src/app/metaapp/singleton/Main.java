package app.metaapp.singleton;

/**
 * @author dimmy
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(A.get());
        System.out.println(B.getInstance().out());
        System.out.println(C.INSTANCE.getName());
    }
}
