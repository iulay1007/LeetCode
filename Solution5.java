/*
 9.������
�ж�һ�������Ƿ��ǻ���������������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������
*/
public class Solution5 {
	 public boolean isPalindrome(int x) {
		 
		 boolean result =false;
		 
		 if(x==0)
		
			 return result=true;
			
		 String str1=Integer.toString(x);
		 if(str1.endsWith("0")) return result;
		 
		 StringBuffer str2=new StringBuffer(str1);
		    StringBuffer str3=str2.reverse();
		   String str4=str3.toString(); 
		    if(str1.equals(str4))
		    	return result=true;
		    
		 return result=false;
	 }
		 
		 
		 public static void main(String[] args) {
				
				Solution5 re=new Solution5();
			boolean res=re.isPalindrome(-121);
			System.out.print(res);
				

			}

}
