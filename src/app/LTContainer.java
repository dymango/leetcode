package app;

import app.leetcode.SubtreeWithAllDeepest_865;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dimmy
 */
public class LTContainer {
    private List<LeetCode> leetCodes = new ArrayList<>();
    private List<String> unResolveNames = new ArrayList<>();

    public void load() {
        leetCodes.add(new SubtreeWithAllDeepest_865());
    }

    public void analysis() throws ClassNotFoundException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class<?> aClass = classLoader.loadClass("FindMinDifference_539");
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            boolean unResolve = annotation.annotationType().getSimpleName().equals("UnResolve");
            if (unResolve) {
                UnResolve unResolveAn = (UnResolve) annotation;
                unResolveNames.add(aClass.getSimpleName() + ": " + unResolveAn.type());
            }
        }
    }

    public void out() {
        System.out.println(unResolveNames.stream().collect(Collectors.joining(",")));
    }

    public static void main(String[] args) throws ClassNotFoundException {
        LTContainer l = new LTContainer();
        l.load();
        l.analysis();
        l.out();
    }
}
