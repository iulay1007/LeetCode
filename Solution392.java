/*
 * �����ַ��� s �� t ���ж� s �Ƿ�Ϊ t �������С�

�������Ϊ s �� t �н�����Ӣ��Сд��ĸ���ַ��� t ���ܻ�ܳ������� ~= 500,000������ s �Ǹ����ַ��������� <=100����

�ַ�����һ����������ԭʼ�ַ���ɾ��һЩ��Ҳ���Բ�ɾ�����ַ������ı�ʣ���ַ����λ���γɵ����ַ����������磬"ace"��"abcde"��һ�������У���"aec"���ǣ���

*/
public class Solution392 { 
	
	public boolean isSubsequence(String s, String t) {


		
	 char[] shortArray = s.toCharArray();
	    int j =0;
	        for(int i = 0;i<shortArray.length;i++) {
	            j = t.indexOf(shortArray[i],j);
	            if(j==-1) {
	                return false;
	            }
	         
	          j++;
	        }
	        return true;
	   


		
}
	public static void main(String[] args) {
		
		Solution392 solution=new Solution392();
		String s="aji";
		String t="acdfijn";
		
	
		boolean result=solution.isSubsequence(s, t);
	System.out.print(result);

	

		
		
		
	}
}

