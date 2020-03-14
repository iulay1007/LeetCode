
import java.util.*;

/*35. 搜索插入位置
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，
返回它将会被按顺序插入的位置。
你可以假设数组中无重复元素。 

 */
public class Solution7 { 
	public int searchInsert(int[] nums, int target) {
		int length=nums.length;
		int result = 0;
		  Map<Integer, Integer> map = new HashMap<>();
		if(target<=nums[0])
			return 0;
		else if(target>nums[length-1])
			return length;
		 for (int i = 0; i < length; i++) {
	            map.put(nums[i], i);
	        }
		 if(map.containsKey(target))
			return result=map.get(target).intValue();
		for(int j=0;j<length;j++)
			if(nums[j]>target)
			{
				result=j;
				break;
			}
	
		
		return result;
		

}

	public static void main(String[] args) {
		
		Solution7 solution=new Solution7();
		int num[]= {1,2,3,5};
		int result=solution.searchInsert(num, 2);
		System.out.print(result);
		
		
	}
	
}