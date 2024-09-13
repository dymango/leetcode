package leetcodepractice.twohundred;

import java.util.ArrayList;
import java.util.List;

public class restoreIpAddresses93 {

    public List<String> restoreIpAddresses(String s) {
        if(s.length() < 4 || s.startsWith("0")) return new ArrayList<>();
        List<String> r = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length() - 3, s.length()); i++) {
            String a = s.substring(0, i + 1);
            if(a.length() != 1 && a.startsWith("0") || a.length() > 3) continue;
            int an = Integer.parseInt(a);
            if(an >255) continue;
            for (int j = i + 1; j < Math.min(i + 4, s.length() - 2); j++) {
                String b = s.substring(i + 1, j + 1);
                if(b.length() != 1 && b.startsWith("0") || b.length() > 3) continue;
                int bn = Integer.parseInt(b);
                if(bn >255) continue;
                for (int k = j + 1; k < Math.min(j + 4, s.length() - 1); k++) {
                    String c = s.substring(j + 1, k + 1);
                    if(c.length() != 1 && c.startsWith("0") || c.length() > 3) continue;
                    int cn = Integer.parseInt(c);
                    if(cn >255) continue;

                    String d = s.substring(k + 1);
                    if(d.length() != 1 && d.startsWith("0") || d.length() > 3) continue;
                    int dn = Integer.parseInt(d);
                    if(dn >255) continue;
                    r.add(a+"."+b+"."+c+"."+d);
                }
            }
        }

        return r;
    }
}
