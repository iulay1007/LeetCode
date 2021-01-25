/*
77. 组合
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/
import java.util.ArrayList;
import java.util.List;

public class Solution77 {
    public List<List<Integer>> result=new ArrayList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> track=new ArrayList<>();
        backtrack(n,k,track,1);
        return result;
    }
    public void backtrack(int n,int k,List<Integer> track,int s){
        if(track.size()==k) {
            result.add(new ArrayList<>(track));
            return;
        }
        for(int i=s;i<=n;i++){
            track.add(i);
            backtrack(n,k,track,i+1);
            track.remove(track.size()-1);
        }
    }
}