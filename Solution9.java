/* 
 *58.���һ�����ʵĳ���
����һ����������Сд��ĸ�Ϳո� ' ' ���ַ��� s�����������һ�����ʵĳ��ȡ�����ַ����������ҹ�����ʾ����ô���һ�����ʾ��������ֵĵ��ʡ�

������������һ�����ʣ��뷵�� 0 ��

˵����һ��������ָ������ĸ��ɡ��������κοո��ַ��� ������ַ�����

  */
public class Solution9 {
	public int lengthOfLastWord(String s) {
		
		int result;
		String str="";
		 s = s.trim();
		 if(s.contains(" "))
		{
			str=s.substring(s.lastIndexOf(" "), s.length()-1);
		
		result=str.length();
		
		}	
		else result=s.length();
		
		
		return result;
		
		
		
		
		

    }
	
	
	public static void main(String[] args) {
		 Solution9 solution =new Solution9();
		
	String s="b   a    ";
		int result=solution.lengthOfLastWord(s);
		 System.out.print(result);
		 
		 
	 }

}