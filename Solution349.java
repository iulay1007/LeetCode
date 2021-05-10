import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/*
349. 两个数组的交集
给定两个数组，编写一个函数来计算它们的交集。



示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]
示例 2：

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]
 */
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set =new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int f=0;
        for(int i=0;i< nums1.length&&f<nums2.length;i++){
            if(nums1[i]==nums2[f])
            {
                set.add(nums1[i]);
                f++;
            }
            else if(nums1[i]>nums2[f])
            {
                f++;
                i--;
            }
        }
        int []arr=new int[set.size()];
        int i=0;

        for(int value: set){
            arr[i]=value;
            i++;
        }
        return arr;
    }
}