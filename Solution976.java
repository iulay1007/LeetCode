/*
 * ������һЩ�����������ȣ���ɵ����� A����������������������ɵġ������Ϊ��������ε�����ܳ���

��������γ��κ������Ϊ��������Σ����� 0
*/
import java.util.Arrays;

public class Solution976 {
	 public int largestPerimeter(int[] A) {
		 
		 int result=0;
		  	Arrays.sort(A);
	        for(int i = A.length-1;i>1;i--)
	            if( A[i]<A[i-1]+A[i-2] ) {
	            	result= A[i]+A[i-1]+ A[i-2];
	                return  result;
	            	}
	    
	        return result;

	    }


}
