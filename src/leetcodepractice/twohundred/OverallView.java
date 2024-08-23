package leetcodepractice.twohundred;

import leetcodepractice.leetcode.base.ListNode;

/**
 * @author dimmy
 */
public class OverallView {
    //给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
    //
    public int[][] generateMatrix(int n) {
        var matrix = new int[n][n];
        int start = 0;
        int end = 0;
        int direction = 1;
        int num = 1;
        matrix[0][0] = num++;
        var visited = new boolean[matrix.length][matrix[0].length];
        visited[0][0] = true;
        while (true) {
            var result = nextPositionCalculator(matrix, visited, direction, start, end);
            if (result[1] < 0 || result[1] >= matrix.length || result[2] < 0 || result[2] >= matrix[0].length || visited[result[1]][result[2]]) break;
            visited[result[1]][result[2]] = true;
            matrix[result[1]][result[2]] = num++;
            direction = result[0];
            start = result[1];
            end = result[2];
        }

        return matrix;
    }

    private int[] nextPositionCalculator(int[][] matrix, boolean[][] visited, int direction, int x, int y) {
        var row = matrix.length;
        var col = matrix[0].length;
        if (direction == 1) {
            if (y + 1 >= col || visited[x][y + 1]) {
                return new int[]{2, x + 1, y};
            } else {
                return new int[]{1, x, y + 1};
            }
        } else if (direction == 2) {
            if (x + 1 >= row || visited[x + 1][y]) {
                return new int[]{3, x, y - 1};
            } else {
                return new int[]{2, x + 1, y};
            }
        } else if (direction == 3) {
            if (y - 1 < 0 || visited[x][y - 1]) {
                return new int[]{4, x - 1, y};
            } else {
                return new int[]{3, x, y - 1};
            }
        } else {
            if (x - 1 < 0 || visited[x - 1][y]) {
                return new int[]{1, x, y + 1};
            } else {
                return new int[]{4, x - 1, y};
            }
        }
    }


    public static void main(String[] args) {
        new OverallView().rotateRight(new ListNode(1), 0);
    }

    //给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        var vir = head;
        int K = k;
        int count = 0;
        while (true) {
            if (count == K) {
                var splitPointer = head;
                while (vir.next != null) {
                    vir = vir.next;
                    splitPointer = splitPointer.next;
                }


                var newHead = splitPointer.next;
                var temp = newHead;
                splitPointer.next = null;
                while (temp.next != null) {
                    temp = temp.next;
                }

                temp.next = head;
                return newHead;
            }

            vir = vir.next;
            count++;

            if (vir.next == null) {
                vir = head;
                K -= count;
                if (K == 0) return head;
            }
        }
    }

    //一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
    //
    //机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
    //
    //问总共有多少条不同的路径？
    int[][] cache = new int[101][101];
    boolean[][] visited = new boolean[101][101];

    public int uniquePaths(int m, int n) {
        int[][] steps = new int[m][n];
        steps[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 && j == 0) continue;
                steps[i][j] = (i - 1 >= 0 ? steps[i - 1][j] : 0)
                    + (j - 1 >= 0 ? steps[i][j - 1] : 0);
            }
        }

        return steps[m - 1][n - 1];
    }
}
