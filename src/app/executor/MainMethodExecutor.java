package app.executor;

import app.executor.exception.InvalidParamException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class MainMethodExecutor {

    public void execute(Class<?> targetClass) {
        Object response = null;
        try {
            Object o = targetClass.getDeclaredConstructor().newInstance();
            Method[] methods = targetClass.getMethods();
            Field[] declaredFields = targetClass.getDeclaredFields();
            for (Method method : methods) {
                MainMethod mainMethod = method.getAnnotation(MainMethod.class);
                if (mainMethod != null) {
                    List<Object> params = new ArrayList<>();
                    for (Field declaredField : declaredFields) {
                        MainParam mainParam = declaredField.getAnnotation(MainParam.class);
                        if (mainParam != null) {
                            declaredField.setAccessible(true);
                            Object value = declaredField.get(o);
                            if (mainParam.notNull() && value == null) throw new InvalidParamException("invalid main param");
                            params.add(value);
                        }
                    }

                    response = method.invoke(o, params.toArray());
                    break;
                }
            }
        } catch (InvocationTargetException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvalidParamException e) {
            throw new RuntimeException(e);
        }

        ResultPrinter.output(response);
    }
}
