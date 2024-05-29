package interview.experience.metaapp;

/**
 * @author dimmy
 */
public class A {

    class Inner {
        public String v1 = "Fake News";
        public String v2 = "Go ahead";
    }

    private static String GetVal() {
        try {
            return Inner.class.newInstance().v1;
        } catch (Exception e) {
            try {
                return Inner.class.getDeclaredConstructor(A.class).newInstance((A) null).v2;
            } catch (Exception ee) {
                ee.printStackTrace();
                return "Fake News, Go ahead";
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(((A) null));
        A a = new A();
        Inner inner = a.new Inner();
        System.out.println(GetVal());
    }
}
