package 剑指offer;

import java.util.*;

/**
 * 剑指 Offer II 075. 数组相对排序
 给定两个数组，arr1 和 arr2，

 arr2 中的元素各不相同
 arr2 中的每个元素都出现在 arr1 中
 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。



 示例：

 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 输出：[2,2,2,1,4,3,3,9,6,7,19]


 提示：

 1 <= arr1.length, arr2.length <= 1000
 0 <= arr1[i], arr2[i] <= 1000
 arr2 中的元素 arr2[i] 各不相同
 arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 */
public class OfferII75 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int num :arr2){
            set.add(num);
        }
        for(int num :arr1){
            if(set.contains(num))
            map.put(num,map.getOrDefault(num,0)+1);
            else list.add(num);
        }
        int res[] = new int[arr1.length];
        int pos = 0;
        for(int i = 0;i<arr2.length;i++){
            for(int j =0 ;j<map.get(arr2[i]);j++){
                res[pos] = arr2[i];
                pos++;
            }
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int i = 0;pos<arr1.length;pos++,i++){
            res[pos] = list.get(i);
        }
        return res;
}
}