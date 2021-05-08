/*540. 有序数组中的单一元素
给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。

示例 1:

输入: [1,1,2,3,3,4,4,8,8]
输出: 2
示例 2:

输入: [3,3,7,7,10,11,11]
输出: 10
注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。

*/
public class Solution540 {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int slow=0,fast;
        for(int i=0;i<nums.length;i++)
        {

            fast=slow+1;
            if(fast>=nums.length)
                break;
            if(nums[slow]!=nums[fast])
                return nums[slow];
            slow+=2;
        }
        return nums[nums.length-1];
    }
}
/*
二分的神奇思路
思路：观察例子我们可以发现，在题目要求的数字（出现一次的数字）之前，两个重复的数字的位置是偶-奇，但是出现之后两个重复的数字就变成的奇-偶，我们可以使用这个性质进行二分搜索
成功：mid的左边和右边都和它不相等，此时就返回
第一种失败：mid为奇数，同时nums[mid + 1] == nums[mid]，也就是奇-偶，说明那个数字已经出现了，我们就使r = mid - 1
第二种失败：mid为偶数，同时nums[mid - 1] == nums[mid]，也就是奇-偶，说明那个数字已经出现了，我们就使r = mid - 1
第三种失败：mid为奇数，同时nums[mid - 1] == nums[mid]，也就是偶-奇，说明那个数字还没有出现，我们就使l = mid + 1
第四种失败：mid为偶数，同时nums[mid + 1] == nums[mid]，也就是偶-奇，说明那个数字还没有出现，我们就使l = mid + 1
需要注意的是，我们需要处理边界线情况，即mid == 0 || mid == nums.size() - 1mid==0∣∣mid==nums.size()−1，处理方法见代码。
当循环退出时，l == r，说明nums[l]nums[l]就是答案

class Solution {
public:
    int singleNonDuplicate(vector<int>& nums) {
        //在出现一次的数字之前，都是偶奇，出现之后就是奇偶
        int l(0), r(nums.size() - 1);
        while (l < r) {
            int mid = (l + r) >> 1;
            if (!mid && nums[mid + 1] != nums[mid]) return nums[0];
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])   return nums[mid];
            else if (mid % 2 && nums[mid + 1] == nums[mid]) r = mid - 1;
            else if (!(mid % 2) && nums[mid - 1] == nums[mid])  r = mid - 1;
            else if (mid % 2 && nums[mid - 1] == nums[mid]) l = mid + 1;
            else if (!(mid % 2) && nums[mid + 1] == nums[mid])  l = mid + 1;
        }
        return nums[l];
    }
};
*/