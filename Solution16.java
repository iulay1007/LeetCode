/*557. ��ת�ַ����еĵ��� III
 * ����һ���ַ���������Ҫ��ת�ַ�����ÿ�����ʵ��ַ�˳��ͬʱ�Ա����ո�͵��ʵĳ�ʼ˳��

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