package app.executor;

import java.util.List;

/**
 * @author dimmy
 */
public class ResultPrinter {
    public static void output(Object object) {
        if (object != null) {
            if (object instanceof int[] r) {
                for (int p : r) {
                    System.out.println(p);
                }
            } else if (object instanceof List<?> list) {
                for (Object o : list) {
                    System.out.println(o);
                }
            } else if (object instanceof String[] arr) {
                for (Object o : arr) {
                    System.out.println(o);
                }
            } else {
                System.out.println(object);
            }
        }
    }
}
