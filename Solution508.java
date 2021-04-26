import java.util.*;
/*508. 出现次数最多的子树元素和
给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。

你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。



示例 1：
输入:

  5
 /  \
2   -3
返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。

示例 2：
输入：

  5
 /  \
2   -5
返回 [2]，只有 2 出现两次，-5 只出现 1 次。*/
public class Solution508 {
    List<Integer> list=new ArrayList<Integer>();
    public int[] findFrequentTreeSum(TreeNode root) {

        int repeat=1;
        List<Integer> temp=new ArrayList<>();
        dfs(root);

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        int fast;
        int max=1;
        for(int i=0;i<list.size();i++) {
            fast=i+1;
            repeat=1;
            while (fast<list.size()&&list.get(i).equals(list.get(fast)))
            {
                repeat++;
                fast++;
            }
            if(repeat>max){
                temp.clear();
                temp.add(list.get(i));
            }
            else if(repeat==max)
                temp.add(list.get(i));
            max=Math.max(max,repeat);
            i=fast-1;

        }
        int [] result=new int[temp.size()];
        for(int i=0;i<temp.size();i++)
            result[i]=temp.get(i);
        return result;
    }

    private int dfs(TreeNode root) {
        if(root==null)
            return 0;
        root.val=dfs(root.left)+dfs(root.right)+ root.val;
        list.add(root.val);
        return root.val;
    }
}
//别人的map，原本也想用map，然而不会找出每一个key
/*import java.util.ArrayList;
import java.util.HashMap;
class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        findSum(root);
        ArrayList<Integer> list = new ArrayList<>(); 
        for(int i : map.keySet()){
            if(map.get(i) == max){
                list.add(i);
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0; i<result.length; i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public int findSum(TreeNode root){
        if(root == null){
            return 0;
        }
        //计算左子树的和
        int left = findSum(root.left);
        //计算右子树的和
        int right = findSum(root.right);
        //计算当前子树的和
        int sum = root.val + left + right;
        //将结果放入HashMap中，并计算出出现的最多次数
        map.put(sum,map.getOrDefault(sum,0)+1);
        max = Math.max(max,map.get(sum));
        return sum;
    }
}
*/