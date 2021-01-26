/*
37. 解数独
编写一个程序，通过填充空格来解决数独问题。

一个数独的解法需遵循如下规则：

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
空白格用 '.' 表示。
*/
public class Solution37 {
    public void solveSudoku(char[][] board) {

        backtrack(0,0,board);
        return;
    }
    public boolean backtrack(int r,int c,char[][] board){
        if(c==9)
            return  backtrack(r+1,0,board);

        if(r==9)
            return true;
        for(int i=r;i<9;i++)
            for(int j=c;j<9;j++)
            {
                if(board[i][j]!='.')
                    return backtrack(i,j+1,board);
                for(char k='1';k<='9';k++)
                {
                    if(!isVaild(i,j,k,board))
                        continue;
                    board[i][j]=k;
                    if  ( backtrack(i,j+1,board))
                        return true;
                    board[i][j]='.';
                }
                return false;
            }

        return false;
    }

    boolean isVaild(int r,int c,int num,char [][]board){
        for(int i=0;i<9;i++)
        {
            if(board[r][i]==num) return false;
            if(board[i][c]==num) return false;
            if(board[r/3*3+i/3][c/3*3+i%3]==num)
                return false;
        }
        return true;
    }
}