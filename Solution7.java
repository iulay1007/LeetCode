
import java.util.*;

/*35. ��������λ��
����һ�����������һ��Ŀ��ֵ�����������ҵ�Ŀ��ֵ�������������������Ŀ��ֵ�������������У�
���������ᱻ��˳������λ�á�
����Լ������������ظ�Ԫ�ء� 

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