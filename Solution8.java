/*
 14.最长公共前缀
 编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。 */
public class Solution8 {
	 public String longestCommonPrefix(String[] strs) {
		 String result="";
		String prefix="";
		 if(strs==null||strs.length==0)
			 return "";
		 if(strs.length==1)
			 return strs[0];
		 for(int i=0;i<strs[0].length();i++) {
			 if(strs[0].length()==1)
				 prefix=strs[0];
			 else if(strs.length>1)
				 prefix=strs[0].substring(0, i+1);
	
		 for(int j=0;j<strs.length;j++)
		 { 
			 if(strs[j].startsWith(prefix)==false)
			 return result;
			 
	
		 }
		 result=prefix;

		 
	    }
		 
	 
		 return result;
	 }
	 
	 public static void main(String[] args) {
		 Solution8 solution =new Solution8();
		
		String[] strs= {"abcd","abcde"};
		String  result=solution.longestCommonPrefix(strs);
		 System.out.print(result);
		 
		 
	 }
	 
	
	}