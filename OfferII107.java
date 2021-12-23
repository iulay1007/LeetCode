package 剑指offer;
/**
 * 剑指 Offer II 107. 矩阵中的距离
 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。

 两个相邻元素间的距离为 1 。



 示例 1：



 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
 输出：[[0,0,0],[0,1,0],[0,0,0]]
 示例 2：



 输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
 输出：[[0,0,0],[0,1,0],[1,2,1]]


 提示：

 m == mat.length
 n == mat[i].length
 1 <= m, n <= 104
 1 <= m * n <= 104
 mat[i][j] is either 0 or 1.
 mat 中至少有一个 0
 */
public class OfferII107 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        int[][] res = new int[m][n];
        //1的上下左右有0的，res里直接填1
        for (int i = 0;i<m;i++){
            for (int j = 0;j<n;j++){
                if(mat[i][j] == 0){
                }else {
                    if(j>0&&mat[i][j-1]==0){
                        res[i][j] =1;
                    }else if(i>0&&mat[i-1][j] == 0){
                        res[i][j] =1;
                    }else if(j< n-1&&mat[i][j+1] == 0){
                        res[i][j] =1;
                    }else if(i<m-1&&mat[i+1][j] == 0){
                        res[i][j] =1;
                    }
                }

            }

        }

        //从左上开始
        for (int i = 0;i<m;i++){
            for (int j = 0;j<n;j++){
                if(mat[i][j]!=0&&res[i][j]==0){
                    int min = Integer.MAX_VALUE;
                    if(i>0&&res[i-1][j]!=0){
                        if(res[i][j] == 0)
                            min = res[i-1][j];
                        else {
                            min = Math.min(res[i][j],res[i-1][j]);
                        }
                    }
                    if(j>0&&res[i][j] ==0){
                        if(res[i][j] == 0)
                            min =Math.min(min, res[i][j-1]);
                        else  min = Math.min(min,Math.min(res[i][j],res[i][j-1]));
                    }
                    if(min!=Integer.MAX_VALUE&&min!=res[i][j]){
                        res[i][j] = min+1;
                    }
                }

            }
        }
        //从右下开始
        for (int i = m-1;i>=0;i--){
            for (int j = n-1;j>=0;j--){
                if(mat[i][j]!=0&&res[i][j]!=1){
                    int min = Integer.MAX_VALUE;

                    if(i<m-1&&res[i+1][j]!=0){
                        if(res[i][j] == 0)
                            min = res[i+1][j];
                        else min = Math.min(res[i][j],res[i+1][j]);
                    }
                    if(j<n-1&&res[i][j+1] !=0){
                        if(res[i][j] == 0)
                            min = Math.min(min,res[i][j+1]);
                        else min =Math.min(min, Math.min(res[i][j],res[i][j+1]));
                    }
                    if(min!=Integer.MAX_VALUE&&min!=res[i][j]){
                        res[i][j] = min+1;
                    }
                }

            }
        }
        return res;

    }
}
