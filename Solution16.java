/*557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

 * */
public class Solution16 { 
	public String reverseWords(String s) {
		String result="";
		String part="";
		boolean zt=true;
		char c[]=s.toCharArray();
try {	
			for (int j=0;j<s.length();j++)
			{
				if(c[j]==' '&&zt==true||j==s.length()-1) {
					
					int k=j-1;
					if(j==s.length()-1) k=j;
				while(k<0==false&&c[k]!=' ') {
					
					part=part+c[k]+"";
					k--;
					
				}
				
				zt=false;
				}
				result=result+part;
				part="";
				zt=true;
				
			
			
			
			
		}}catch(Exception e) {return result;}

		
		
		return result;
}
	 public static void main(String[] args) {
			
			Solution16 solution=new Solution16();
			String s="iu love you";
			String result=solution.reverseWords(s);
		
		System.out.print(result);
	
		

			
			
			
		}
}