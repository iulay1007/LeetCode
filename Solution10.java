/*
 * 66.��һ
 * ����һ����������ɵķǿ���������ʾ�ķǸ��������ڸ����Ļ����ϼ�һ��

���λ���ִ�����������λ�� ������ÿ��Ԫ��ֻ�洢�������֡�

����Լ���������� 0 ֮�⣬��������������㿪ͷ
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