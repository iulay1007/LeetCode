/*
 * 521. ��������� ��
 * ���������ַ���������Ҫ���������ַ������ҳ�����������С���������ж������£�������Ϊĳ�ַ������е�������У��������������ַ����������У���

�����п���ͨ��ɾȥ�ַ����е�ĳЩ�ַ�ʵ�֣������ܸı�ʣ���ַ������˳�򡣿�����Ϊ�����ַ����������У��κ��ַ���Ϊ������������С�

����Ϊ�����ַ����������������еĳ��ȡ���������ڣ��򷵻� -1��

 * 
 * */
public class Solution13 { 
	
	 public int findLUSlength(String a, String b) {
		 if(a.equals(b))
			 return -1;
		 if(a.length()>=b.length())
			 return a.length();
		 else return b.length();					
	        
	    }
	
	
	 public static void main(String[] args) {
			
			Solution13 solution=new Solution13();
			String a="abcd";
			String b="qwq";
			int result=solution.findLUSlength(a, b);
			System.out.print(result);
			
			
			
		}
	 
}