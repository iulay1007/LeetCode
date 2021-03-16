/*1578. 避免重复字母的最小删除成本
给你一个字符串 s 和一个整数数组 cost ，其中 cost[i] 是从 s 中删除字符 i 的代价。

返回使字符串任意相邻两个字母不相同的最小删除成本。

请注意，删除一个字符后，删除其他字符的成本不会改变。

 

示例 1：

输入：s = "abaac", cost = [1,2,3,4,5]
输出：3
解释：删除字母 "a" 的成本为 3，然后得到 "abac"（字符串中相邻两个字母不相同）。
示例 2：

输入：s = "abc", cost = [1,2,3]
输出：0
解释：无需删除任何字母，因为字符串中不存在相邻两个字母相同的情况。
示例 3：

输入：s = "aabaa", cost = [1,2,3,4,1]
输出：2
解释：删除第一个和最后一个字母，得到字符串 ("aba") 。
 

提示：*/
public class Solution1578 {
    public int minCost(String s, int[] cost) {
        char ch[] = s.toCharArray();
        int result = 0;
        int slow=0;
        int fast=1;
        int flag=0;
        for (int i = 0; i < ch.length - 1&&slow<ch.length&&fast<ch.length; i++) {
            flag=0;
            while(ch[fast]=='0'&&fast<ch.length)
                fast++;
            while (ch[slow]=='0')
                slow++;
            if (ch[slow] == ch[fast]) {
                flag=1;
                if (cost[slow] <= cost[fast]) {
                    result += cost[slow];
                    ch[slow] = '0';
                    slow=fast;
                    fast++;

                } else {
                    result += cost[fast];
                    ch[fast] = '0';
                    fast++;
                }
            }
            if(flag==0)
            {
                slow++;
                fast++;
            }

        }
        return result;
    }

}