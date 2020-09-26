package com.gavin.leetcode.april;

/**
 * #289.生命游戏
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 *
 * @Author Gavin
 * @Date 2020/4/3
 * @Time 14:33
 */
public class GameOfLife {

    public void gameOfLife(int[][] board) {
        int neighbor[] = {-1, 0, 1};

        int rows = board.length;
        int cols = board[0].length;

        int[][] copyBoard = new int[rows][cols];

        for (int row = 0; row < rows; row++) {//拷贝数组
            for (int col = 0; col < cols; col++) {
                copyBoard[row][col] = board[row][col];
            }
        }

        for (int row = 0; row < rows; row++) {//遍历数组
            for (int col = 0; col < cols; col++) {
                int liveNeighbors = 0;

                for (int i = 0; i < 3; i++) {//对于每个元素，遍历相邻8个元素
                    for (int j = 0; j < 3; j++) {
                        if (!(neighbor[i] == 0 && neighbor[j] == 0)) {
                            int r = row + neighbor[i];
                            int c = col + neighbor[j];

                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (copyBoard[r][c] == 1))
                                liveNeighbors++;
                        }
                    }
                }

                if ((copyBoard[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3))
                    board[row][col] = 0;
                if ((copyBoard[row][col] == 0) && (liveNeighbors == 3))
                    board[row][col] = 1;
            }
        }
    }
}
