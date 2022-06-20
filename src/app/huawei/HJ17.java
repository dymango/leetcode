package app.huawei;

import java.util.Scanner;

/**
 * @author dimmy
 */
public class HJ17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String next = in.next();
            int x = 0, y = 0;
            String[] split = next.split(";");
            for (String s : split) {
                if(s.length() < 2) continue;
                String substring = s.substring(0, 1);
                if(!substring.startsWith("A") && !substring.startsWith("S") && !substring.startsWith("D") && !substring.startsWith("W")) continue;
                try {
                    Integer integer = Integer.valueOf(s.substring(1));
                    if(substring.equals("A")) {
                        x -= integer;
                    } else if(substring.equals("D")) {
                        x += integer;
                    }else if(substring.equals("W")) {
                        y += integer;
                    } else {
                        y -= integer;
                    }
                } catch (Exception e) {
                    continue;
                }
            }

            System.out.println(x+","+y);
        }
    }
}
