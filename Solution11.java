/*136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，
 *其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 
 * */

import java.util.*;

public class Solution11 {
	 public int singleNumber(int[] nums) {
		
		
		 Arrays.sort(nums);
		
		 for(int j=0;j<=nums.length;j=j+2)
		 {
			 
			try { if(j==nums.length)
				 return nums [j];
			 else if(nums [j]==nums[j+1]==false)
				 return nums [j];
			}catch (Exception e) {
				return nums [j];
			}
			 
		 }
		 
		 
		 
		 return 0;
		 
		
	
	    }
	 public static void main(String[] args) {
			
			Solution11 solution=new Solution11();
			int num[]= {1,1,3,3,5};
			int result=solution.singleNumber(num);
			System.out.print(result);
			
			
		}
	}