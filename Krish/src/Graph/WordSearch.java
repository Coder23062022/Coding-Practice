package Krish.src.Graph;

//Problem: https://leetcode.com/problems/word-search/
//Video source: https://www.youtube.com/watch?v=pfiQ_PS1g8E&ab_channel=NeetCode
//Video source: https://www.youtube.com/watch?v=m9TrOL1ETxI&ab_channel=NickWhite
//Time complexity: O(m∗n∗4^s)
//Space complexity: O(n)

public class WordSearch {
    static boolean[][] visited;


    static boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && search(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    static boolean search(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;

        if (search(board, word, i - 1, j, index + 1) ||
                search(board, word, i + 1, j, index + 1) ||
                search(board, word, i, j - 1, index + 1) ||
                search(board, word, i, j + 1, index + 1)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println("Searched word is found: " + exist(grid, word));
    }
}