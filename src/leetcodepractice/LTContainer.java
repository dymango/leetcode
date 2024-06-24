package leetcodepractice;

import leetcodepractice.executor.ResultPrinter;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dimmy
 */
public class LTContainer {
    private List<String> leetCodes = new ArrayList<>();
    private List<String> unResolveNames = new ArrayList<>();

    public void load() {

        String projectPath = "C:\\Work\\Project\\lt\\src\\leetcodepractice";
        List<File> files = scanFiles(projectPath, ".java"); // 扫描所有的 .java 文件

        // 处理扫描到的文件
        for (File file : files) {
            String absolutePath = file.getAbsolutePath();
            System.out.println(absolutePath);
            String newPath = absolutePath;
            newPath = newPath.replace("C:\\Work\\Project\\lt\\src\\", "");
            newPath = newPath.replace("\\", ".");
            newPath = newPath.replace(".java", "");
            System.out.println(newPath);
            leetCodes.add(newPath);
            // 可以根据需要进行进一步的操作，如读取文件内容等
        }
    }

    public void analysis() throws ClassNotFoundException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        for (String leetCode : leetCodes) {
            ResultPrinter.output("load class:" + leetCode);
            Class<?> aClass = classLoader.loadClass(leetCode);
            Annotation[] annotations = aClass.getAnnotations();
            for (Annotation annotation : annotations) {
                boolean unResolve = annotation.annotationType().getSimpleName().equals("UnResolve");
                if (unResolve) {
                    UnResolve unResolveAn = (UnResolve) annotation;
                    unResolveNames.add(aClass.getSimpleName() + ": " + unResolveAn.type());
                }
            }
        }
    }

    public void out() {
        System.out.println(unResolveNames.stream().collect(Collectors.joining(",")));
    }

    public static List<File> scanFiles(String directoryPath, String fileExtension) {
        List<File> files = new ArrayList<>();
        var directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("Invalid directory path: " + directoryPath);
        }
        scanFilesRecursively(directory, fileExtension, files);
        return files;
    }

    private static void scanFilesRecursively(File baseDir, String fileExtension, List<File> files) {
        var fileList = baseDir.listFiles();
        if (fileList != null) {
            for (var file : fileList) {
                if (file.isDirectory()) {
                    scanFilesRecursively(file, fileExtension, files);
                } else if (file.isFile() && file.getName().endsWith(fileExtension)) {
                    files.add(file);
                }
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        LTContainer l = new LTContainer();
        l.load();
        l.analysis();
        l.out();
    }
}
