/*����һ���ַ������ҵ����ĵ�һ�����ظ����ַ���������������������������ڣ��򷵻� -1��


ʾ����

s = "leetcode"
���� 0

s = "loveleetcode"
���� 2*/
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