/*
74. 搜索二维矩阵
编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。


示例 1：


输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
输出：true
示例 2：


输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
输出：false
*/

public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0;
        int r= matrix.length-1;
        int mid=0;
        while (l<=r)
        {
            mid=(r+l)/2;
            if(target>=matrix[mid][0]&&target<=matrix[mid][matrix[mid].length-1])
                break;
            if(matrix[mid][0]>=target) r=mid-1;
            else if(matrix[mid][matrix[mid].length-1]<target)l=mid+1;


        }

        for(int i=0;i<matrix[mid].length;i++)
            if(matrix[mid][i]==target)
                return true;
        return false;
    }}
