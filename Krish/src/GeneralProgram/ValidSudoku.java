package src.GeneralProgram;

import java.util.HashSet;
import java.util.Set;

//Problem: https://leetcode.com/problems/valid-sudoku/
//Video source: https://www.youtube.com/watch?v=Pl7mMcBm2b8&ab_channel=NickWhite

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {{'5' , '3' , '.' , '.' , '7' , '.' , '.' , '.' , '.'}
                , {'6' , '.' , '.' , '1' , '9' , '5' , '.' , '.' , '.'}
                , {'.' , '9' , '8' , '.' , '.' , '.' , '.' , '6' , '.'}
                , {'8' , '.' , '.' , '.' , '6' , '.' , '.' , '.' , '3'}
                , {'4' , '.' , '.' , '8' , '.' , '3' , '.' , '.' , '1'}
                , {'7' , '.' , '.' , '.' , '2' , '.' , '.' , '.' , '6'}
                , {'.' , '6' , '.' , '.' , '.' , '.' , '2' , '8' , '.'}
                , {'.' , '.' , '.' , '4' , '1' , '9' , '.' , '.' , '5'}
                , {'.' , '.' , '.' , '.' , '8' , '.' , '.' , '7' , '9'}};
        System.out.println(isValidSudoku(board));
    }

    static boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    //The add() function returns True if the element is not present in the HashSet
                    //otherwise False if the element is already present in the HashSet.
                    if (!seen.add(board[i][j] + "row" + i) ||
                            !seen.add(board[i][j] + "column" + j) ||
                            !seen.add(board[i][j] + "block" + i / 3 + "-" + j / 3))
                        return false;
                }
            }
        }
        return true;
    }
}
