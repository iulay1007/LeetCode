import java.util.Arrays;
/*1775. 通过最少操作次数使数组的和相等
给你两个长度可能不等的整数数组 nums1 和 nums2 。两个数组中的所有值都在 1 到 6 之间（包含 1 和 6）。

每次操作中，你可以选择 任意 数组中的任意一个整数，将它变成 1 到 6 之间 任意 的值（包含 1 和 6）。

请你返回使 nums1 中所有数的和与 nums2 中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1 。


示例 1：

输入：nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
输出：3
解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
- 将 nums2[0] 变为 6 。 nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2] 。
- 将 nums1[5] 变为 1 。 nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2] 。
- 将 nums1[2] 变为 2 。 nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2] 。
示例 2：

输入：nums1 = [1,1,1,1,1,1,1], nums2 = [6]
输出：-1
解释：没有办法减少 nums1 的和或者增加 nums2 的和使二者相等。
示例 3：

输入：nums1 = [6,6], nums2 = [1]
输出：3
解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
- 将 nums1[0] 变为 2 。 nums1 = [2,6], nums2 = [1] 。
- 将 nums1[1] 变为 2 。 nums1 = [2,2], nums2 = [1] 。
- 将 nums2[0] 变为 4 。 nums1 = [2,2], nums2 = [4] 。

 */
public class Solution1775 {
    public int minOperations(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int sum1=0;
        int sum2=0;
        int sum3=0;
        int step=0;
        for (int j : nums1) sum1 += j;
        for (int j : nums2) sum2 += j;
        if(sum1==sum2)
            return 0;
        int []num=new int[nums1.length+ nums2.length];
        if(sum1>sum2)
        {
            for(int i=0;i< nums1.length;i++)
                num[i]=nums1[i]-1;
            for(int i=nums1.length;i< nums1.length+nums2.length;i++)
                num[i]=6-nums2[i- nums1.length];
        }
        else {

            for(int i=0;i< nums1.length;i++)
                num[i]=6-nums1[i];
            for(int i=nums1.length;i< nums1.length+ nums2.length;i++)
                num[i]=nums2[i- nums1.length]-1;
        }
        for (int j : num) sum3 += j;
        int abs=Math.abs(sum1-sum2);
        if(sum3<abs)
            return -1;
        Arrays.sort(num);
        for(int j=num.length-1;j>=0;j--)
        {
            abs-=num[j];
            step++;
            if(abs<=0)
                return step;
        }
        return -1;

    }}