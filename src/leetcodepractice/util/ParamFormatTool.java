package leetcodepractice.util;

/**
 * @author dimmy
 */
public class ParamFormatTool {

    public static String formatArray(String arrStr) {
        return arrStr.replace("[", "{").replace("]", "}");
    }

    public static void main(String[] args) {
        System.out.println(ParamFormatTool.formatArray("[[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]"));
    }
}
