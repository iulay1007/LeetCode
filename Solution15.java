/*169. 多数元素
 * 
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * */
import java.util.*;

public class Solution15 {

	
	public int majorityElement(int[] nums) {
	
		int count=1;
	 Arrays.sort(nums);
		int result =nums[0];
		
try {	for(int i=0;i<nums.length-1;i++) {
	
		if(nums[i+1]==nums[i])
			{
			count++;
			if(count>nums.length/2)
			{
				
				return result;
			
			
			}
			
			}
		else {
		result=nums[i+1];
		count =1;
		}
		
	}}catch(Exception e) {return result;}
	
	return result;
	
	}
	
	
	
	
	
	
	 public static void main(String[] args) {
			
			Solution15 solution=new Solution15();
			int nums[]= {1,2,2,2,2,2,6,1};
		int result=solution.majorityElement(nums);
		System.out.print(result);
		//	boolean result=solution.major(a);
		

			
			
			
		}
}
