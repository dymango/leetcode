package app.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dimmy
 */
public class FourSumCount_454 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> abMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                Integer integer = abMap.get(A[i] + B[j]);
                if(integer == null) integer = 1;
                else integer += 1;
                abMap.put(A[i] + B[j], integer);
            }
        }

        Map<Integer, Integer> cdMap = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                Integer integer = cdMap.get(C[i] + D[j]);
                if(integer == null) integer = 1;
                else integer += 1;
                cdMap.put(C[i] + D[j], integer);
            }
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : abMap.entrySet()) {
            Integer integer1 = cdMap.get(0 - entry.getKey());
            if (integer1 != null) count += (entry.getValue() * integer1);
        }

        return count;
    }
}
