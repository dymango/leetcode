package app.executor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author dimmy
 */
public class MainMethodExecutor {

    public void execute(String className, List<Object> params) {
        Object response = null;
        try {
            Class<?> targetClass = Class.forName(className);
            Object o = targetClass.getDeclaredConstructor().newInstance();
            Method[] methods = targetClass.getMethods();
            for (Method method : methods) {
                Main annotation = method.getAnnotation(Main.class);
                if (annotation != null) {
                    response = method.invoke(o, params.toArray());
                }
            }
        } catch (ClassNotFoundException | InvocationTargetException | IllegalAccessException | InstantiationException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        ResultPrinter.output(response);
    }
}
