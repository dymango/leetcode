package app.executor;

/**
 * @author dimmy
 */
public class ResultPrinter {
    public static void output(Object object) {
        if (object != null) {
            if (object instanceof int[]) {
                int[] r = (int[]) object;
                for (int p : r) {
                    System.out.println(p);
                }
            } else {
                System.out.println(object);
            }
        }
    }
}
