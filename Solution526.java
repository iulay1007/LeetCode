import java.util.ArrayList;
import java.util.List;

/*526. 优美的排列
假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：

第 i 位的数字能被 i 整除
i 能被第 i 位上的数字整除
现在给定一个整数 N，请问可以构造多少个优美的排列？

示例1:

输入: 2
输出: 2
解释: 

第 1 个优美的排列是 [1, 2]:
  第 1 个位置（i=1）上的数字是1，1能被 i（i=1）整除
  第 2 个位置（i=2）上的数字是2，2能被 i（i=2）整除

第 2 个优美的排列是 [2, 1]:
  第 1 个位置（i=1）上的数字是2，2能被 i（i=1）整除
  第 2 个位置（i=2）上的数字是1，i（i=2）能被 1 整除
说明:

N 是一个正整数，并且不会超过15*/
/*执行用时：
1037 ms
, 在所有 Java 提交中击败了
5.01%
的用户
内存消耗：
37.8 MB
, 在所有 Java 提交中击败了
10.17%
的用户*/


public class Solution526 {
    int result = 0 ;
    public int countArrangement(int n) {

      backtrack(n,new ArrayList<>(),0);
      return result;
    }


    void backtrack(int n , List<Integer> track, int position){

        if(position==0){

        }
        else if(position>=1&&(track.get(position-1)%position==0||position%track.get(position-1)==0))
        {

        }
        else{

            return;
        }

        if(position>=n){
            result++;
            return;
        }

        for(int i =1;i<=n;i++){
            if(track.contains(i))
                continue;
            track.add(i);
            backtrack(n,new ArrayList<>(track),track.size());
            track.remove(track.size()-1);
        }

    }
}

/*
别人的代码，其实路径不是很必要，可以用visited数组实现
执行用时：
87 ms
, 在所有 Java 提交中击败了
56.75%
的用户
内存消耗：
35.3 MB
, 在所有 Java 提交中击败了
36.12%
的用户
炫耀一下:



int count = 0;
    public int countArrangement(int N) {
        boolean[] visited = new boolean[N + 1];
        calculate(N, 1, visited);
        return count;
    }
    public void calculate(int N, int pos, boolean[] visited) {
        if (pos > N)
            count++;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                calculate(N, pos + 1, visited);
                visited[i] = false;
            }
        }
    }
}*/