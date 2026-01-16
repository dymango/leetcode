package interview.prepare2025.designparttern.decorate;

import java.lang.reflect.Type;

/**
 * @author dimmy
 */
public class MilkTea implements Food{

    @Override
    public void process() {

    }

    public static <T extends Comparable> T max(T[] array) {
        T max = array[0];
        for (T item : array) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    public Class<?> max(Class<?>[] array) {
        Class<? extends Class> aClass = array[0].getClass();
        var genericSuperclass = aClass.getGenericSuperclass();
        return array[0];
    }
}
