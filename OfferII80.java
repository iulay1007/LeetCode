package 剑指offer;

import java.util.ArrayList;
import java.util.List;
/**剑指 Offer II 080. 含有 k 个元素的组合
 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。



 示例 1:

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
 示例 2:

 输入: n = 1, k = 1
 输出: [[1]]
 */
public class OfferII80 {
    List<List<Integer>> res =new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
    backtrack(n,1,k,new ArrayList<>());
    return res;
}
    void backtrack(int n,int s,int k,List<Integer> path){
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i =s;i<=n;i++){
            path.add(i);
            backtrack(n,i+1,k,new ArrayList<>(path));
            path.remove(path.size()-1);
        }
    }
}