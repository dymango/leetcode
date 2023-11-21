package app.leetcode.tophundred;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author dimmy
 */
public class solve_39 {

    private Map<Integer, Set<Character>> cache = new HashMap<>();
    private Map<Integer, Set<Character>> cache2 = new HashMap<>();
    private Map<Integer, Set<Character>> cache3 = new HashMap<>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            cache.put(i, new HashSet<>());
            cache2.put(i, new HashSet<>());
            cache3.put(i, new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != ' ') {
                    cache.get(i).add(board[i][j]);
                    cache.get(j).add(board[i][j]);
                    cache3.get(i / 3 * 3 + j / 3).add(board[i][j]);
                }
            }
        }

        fill(board);
    }

    public boolean fill(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == ' ') {
                    for (int k = 1; k <= 9; k++) {
                        char next = (char) (48 + k);
                        Set<Character> set = cache.get(i);
                        Set<Character> set1 = cache2.get(j);
                        Set<Character> set2 = cache3.get(i / 3 * 3 + j / 3);
                        if (!set.contains(next) && !set1.contains(next) && !set2.contains(next)) {
                            set.add(next);
                            set1.add(next);
                            set2.add(next);
                            boolean fill = fill(board);
                            set.remove(next);
                            set1.remove(next);
                            set2.remove(next);
                            if (fill) break;
                        }
                    }

                    board[i][j] = ' ';
                }
            }
        }

        return false;
    }
}
