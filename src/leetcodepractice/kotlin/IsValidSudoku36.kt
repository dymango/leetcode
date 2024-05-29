package leetcodepractice.kotlin

/**
 *  @author dimmy
 */
class IsValidSudoku36 {

    /**
     * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。

    数字 1-9 在每一行只能出现一次。
    数字 1-9 在每一列只能出现一次。
    数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
     

    注意：

    一个有效的数独（部分已被填充）不一定是可解的。
    只需要根据以上规则，验证已经填入的数字是否有效即可。
    空白格用 '.' 表示。
     

    示例 1：


    输入：board =
    [["5","3",".",".","7",".",".",".","."]
    ,["6",".",".","1","9","5",".",".","."]
    ,[".","9","8",".",".",".",".","6","."]
    ,["8",".",".",".","6",".",".",".","3"]
    ,["4",".",".","8",".","3",".",".","1"]
    ,["7",".",".",".","2",".",".",".","6"]
    ,[".","6",".",".",".",".","2","8","."]
    ,[".",".",".","4","1","9",".",".","5"]
    ,[".",".",".",".","8",".",".","7","9"]]
    输出：true
    示例 2：

    输入：board =
    [["8","3",".",".","7",".",".",".","."]
    ,["6",".",".","1","9","5",".",".","."]
    ,[".","9","8",".",".",".",".","6","."]
    ,["8",".",".",".","6",".",".",".","3"]
    ,["4",".",".","8",".","3",".",".","1"]
    ,["7",".",".",".","2",".",".",".","6"]
    ,[".","6",".",".",".",".","2","8","."]
    ,[".",".",".","4","1","9",".",".","5"]
    ,[".",".",".",".","8",".",".","7","9"]]
    输出：false
    解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
     

    提示：

    board.length == 9
    board[i].length == 9
    board[i][j] 是一位数字（1-9）或者 '.'

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/valid-sudoku
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        for (index in 0 until 9) {
            val row = board[index]
            var set = mutableSetOf<Char>()
            for (c in row) {
                if (c == '.') continue
                val exist = set.add(c)
                if (!exist) return false;
            }
        }


        for (x in 0 until 9) {
            var set = mutableSetOf<Char>()
            for (y in 0 until 9) {
                val element = board[y][x]
                if (element == '.') continue
                val exist = set.add(element)
                if (!exist) return false
            }
        }

        for (x in 0 until 9 step 3) {
            for (y in 0 until 9 step 3) {
                var set = mutableSetOf<Char>()
                for (a in 0..2) {
                    for (b in 0..2) {
                        val element = board[x + a][y + b]
                        if (element == '.') continue
                        val exist = set.add(element)
                        if (!exist) return false
                    }
                }
            }
        }

        return true
    }
}