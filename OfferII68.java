package 剑指offer;
/**剑指 Offer II 068. 查找插入位置
 给定一个排序的整数数组 nums 和一个整数目标值 target ，请在数组中找到 target ，并返回其下标。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

 请必须使用时间复杂度为 O(log n) 的算法。



 示例 1:

 输入: nums = [1,3,5,6], target = 5
 输出: 2
 示例 2:

 输入: nums = [1,3,5,6], target = 2
 输出: 1
 示例 3:

 输入: nums = [1,3,5,6], target = 7
 输出: 4
 示例 4:

 输入: nums = [1,3,5,6], target = 0
 输出: 0
 示例 5:

 输入: nums = [1], target = 0
 输出: 0*/
public class OfferII68 {
    public int searchInsert(int[] nums, int target) {
        int l =0,r=nums.length-1;
        if(target<nums[0])
            return 0;
        if(target>nums[nums.length-1])
            return nums.length;
        while (l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == target) return mid;
            else if(mid-1>=0&&nums[mid-1]<target&&nums[mid]>target){
                return mid;
            }
            else if(mid+1<nums.length&&nums[mid+1]>target&&nums[mid]<target)
                return mid+1;
            else if(nums[mid]>target){
                r=mid-1;
            }else if(nums[mid]<target){
                l =mid+1;
            }

        }

        return 0;

    }
}
