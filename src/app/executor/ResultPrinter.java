package app.executor;

import java.util.List;

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
            } else if (object instanceof List) {
                List list = (List) object;
                for (Object o : list) {
                    System.out.println(o);
                }
            } else if (object instanceof String[]) {
                String[] arr = (String[]) object;
                for (Object o : arr) {
                    System.out.println(o);
                }
            } else {
                System.out.println(object);
            }
        }
    }
}
