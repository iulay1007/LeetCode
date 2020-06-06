/*给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。


示例：

s = "leetcode"
返回 0

s = "loveleetcode"
返回 2*/
public class Solution387 {
	public int firstUniqChar(String s) {
        int[] count = new int[26];
        char[] letter = s.toCharArray();
        int length = letter.length;
        for(int i = 0; i < length; i++)
            count[letter[i] - 'a']++;
        for(int i = 0; i < length; i++)
            if(count[letter[i] - 'a'] == 1)
                return i;
        return -1;
    }
}