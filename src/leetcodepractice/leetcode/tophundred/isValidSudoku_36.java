package leetcodepractice.leetcode.tophundred;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author dimmy
 */
public class isValidSudoku_36 {

    private Map<Integer, Set<Character>> cache = new HashMap<>();
    private Map<Integer, Set<Character>> cache2 = new HashMap<>();
    private Map<Integer, Set<Character>> cache3 = new HashMap<>();

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean b = checkRow(board, i);
            if (!b) return false;
            boolean b1 = checkColumn(board, i);
            if (!b1) return false;
        }

        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                boolean b = checkArea(board, i, j);
                if(!b) return false;
            }
        }

        return true;
    }

    private boolean checkRow(char[][] board, int r) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (board[r][i] != '.' && !set.add(board[r][i])) return false;
        }
        return true;
    }

    private boolean checkColumn(char[][] board, int c) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (board[i][c] != '.' && !set.add(board[i][c])) return false;
        }
        return true;
    }

    private boolean checkArea(char[][] board, int r, int c) {
        Set<Character> set = new HashSet<>();
        int i = (r / 3) * 3;
        int j = (c / 3) * 3;
        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                if (board[k][l] != '.' && !set.add(board[k][l])) return false;
            }
        }

        return true;
    }
}
