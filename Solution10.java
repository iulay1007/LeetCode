/*
 * 66.加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头
 * 
 * */
public class Solution10 { 
	
	public int[] plusOne(int[] digits) {
	
		
		 for(int i=digits.length-1;i>=0;i--){
			 
	            if(digits[i]==9){
	                digits[i]=0;
	               
	            }
	            else if(digits[i]!=9){
	                digits[i]+=1;
	                break;
	            }
	        }

	        int[] result=new int[digits.length+1];
	        result[0]=1;
	        if(digits[0]==0)
	        	return result;
	        else return digits;
	    }
public static void main(String[] args) {
		
		Solution10 solution=new Solution10();
		int num[]= {9,8,7,6,5,4,3,2,1,0};
		num=solution.plusOne(num);
		System.out.print(num[9]);
		
		
	}
}