package 剑指offer;

import java.util.*;

/**给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，
 * 使得 a + b + c = 0 ？请找出所有和为 0 且 不重复 的三元组。
*/

/**可以用三指针做，前提是把数组进行了排序*/
public class OfferII007 {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer,Integer> nnum = new HashMap<>();
        Map<Integer,Integer> pnum = new HashMap<>();
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int num :nums){
            if(num<0)
                nnum.put(num,nnum.getOrDefault(num,0)+1);
            else pnum.put(num,pnum.getOrDefault(num,0)+1);
        }
        helper(nnum, pnum, lists);
        helper(pnum,nnum,lists);
        if(pnum.containsKey(0)&&pnum.get(0)>=3){
            List<Integer> temp = new ArrayList<>();
            temp.add(0);
            temp.add(0);
            temp.add(0);
            lists.add(temp);
        }
        return lists;
    }

    private void helper(Map<Integer, Integer> nnum, Map<Integer, Integer> pnum, List<List<Integer>> lists) {
        Set<Integer> set = new HashSet<>();
        for (int num: nnum.keySet()){
            set.clear();
            for (int n: pnum.keySet()){
                int m = -num - n;
                if(set.contains(n)||set.contains(m))
                    continue;
                if(m == n){
                    if (pnum.get(m)<=1) continue;
                }else {
                    if (!pnum.containsKey(m)) continue;
                }
                List<Integer> temp = new ArrayList<>();
                temp.add(num);
                temp.add(n);
                temp.add(m);
                set.add(n);
                set.add(m);
                lists.add(temp);
            }
        }
    }

}
