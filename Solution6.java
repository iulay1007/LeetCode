/*28. 实现 strStr()
 实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

 */



public class Solution6 {
	public int strStr(String haystack, String needle) {
	
		int result;
		if(needle.length()==0||haystack.equals(needle))
			return result=0;
		
		result=haystack.indexOf(needle);

	   return result;

}
	public static void main(String[] args) {
		
		Solution6 re=new Solution6();
    int  res=re.strStr("abcde","bc");
	System.out.print(res);
		

	}
}