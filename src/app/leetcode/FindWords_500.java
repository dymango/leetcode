package app.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class FindWords_500 {

    public String[] findWords(String[] words) {
        String charStr = "qwertyuiop";
        String charStr2 = "asdfghjkl";
        String charStr3 = "zxcvbnm";
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            boolean charInSameLine = true;
            int cl = 0;
            if(charStr.contains(String.valueOf(word.charAt(0)))) {
                cl = 1;
            } else if(charStr2.contains(String.valueOf(word.charAt(0)))){
                cl = 2;
            } else if(charStr3.contains(String.valueOf(word.charAt(0)))){
                cl = 3;
            }
            for (int j = 1; j < word.length(); j++) {
                if(charStr.contains(String.valueOf(word.charAt(j)))) {
                    if(cl != 1) charInSameLine =false;
                } else if(charStr2.contains(String.valueOf(word.charAt(j)))){
                    if(cl != 2) charInSameLine =false;

                } else if(charStr3.contains(String.valueOf(word.charAt(j)))){
                    if(cl != 3) charInSameLine =false;
                }
            }

            if(charInSameLine) result.add(words[i]);
        }

        String[] r = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }

        return r;
    }
}
